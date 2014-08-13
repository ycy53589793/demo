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
		
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		Object user = session.getAttribute(Constant.LOGIN_USER);// 获取用户对象

		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();

		// 登陆页面无需过滤
		if (path.indexOf("/login.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		// 创建类Constants.java，里面写的是无需过滤的页面
//		for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
//			if (path.endsWith(Constants.NoFilter_Pages[i])) {
//				chain.doFilter(servletRequest, servletResponse);
//				return;
//			}
//		}
		
		
		// 如果user为空，表示非法访问，跳转到登陆页面
		if (user == null) {
			// 跳转到登陆页面
			String contextPath = servletRequest.getContextPath();
			servletResponse.sendRedirect(contextPath + "/common/login.jsp");
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);
		}

	}

}
