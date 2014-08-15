package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.constant.Constant;

public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// ��������������Ҫ�õ�request,response,session����
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		Object user = session.getAttribute(Constant.STRING.LOGIN_USER);// ��ȡ�û�����

		// ����û������URI
		String path = servletRequest.getRequestURI();

		// ��½ҳ���������
		if (path.indexOf("/login.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		// ������Constants.java������д����������˵�ҳ��
//		for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
//			if (path.endsWith(Constants.NoFilter_Pages[i])) {
//				chain.doFilter(servletRequest, servletResponse);
//				return;
//			}
//		}
		
		
		// ���userΪ�գ���ʾ�Ƿ����ʣ���ת����½ҳ��
		if (user == null) {
			// ��ת����½ҳ��
			String contextPath = servletRequest.getContextPath();
			servletResponse.sendRedirect(contextPath + "/common/login.jsp");
		} else {
			// �Ѿ���½,����˴�����
			chain.doFilter(request, response);
		}

	}

}
