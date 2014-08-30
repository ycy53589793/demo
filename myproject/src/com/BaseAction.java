package com;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Description:   基础action类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String JSON = "json";
	
	protected Subject currentUser = SecurityUtils.getSubject();;
	
	private static ActionContext strutsContext=ActionContext.getContext();
	
	//获取由struts2包装好的request session application
	@SuppressWarnings("rawtypes")
	protected Map strutsRequest = (Map)strutsContext.get("request");
	protected Map<String,Object> strutsSession = strutsContext.getSession();
	protected Map<String,Object> strutsApplication = strutsContext.getApplication();
	//获取servlet的request跟servletContext
	protected HttpServletRequest servletRequest = ServletActionContext.getRequest();
	protected ServletContext servletContext = ServletActionContext.getServletContext();
	protected HttpServletResponse servletResponse = ServletActionContext.getResponse();
	
	public String execute() throws Exception {
		return Action.SUCCESS;
	}
	
}
