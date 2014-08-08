package com.common;

import com.BaseAction;
import com.opensymphony.xwork2.Action;
import com.user.service.UserService;
import com.util.ResultMessage;

/**
 * Description:   登陆页面action
 * @author: 杨聪艺
 * Create Date: 2014-8-8
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-8.1		杨聪艺		2014-8-8		create					
 * </pre>
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641585993706926509L;
	
	private String username;
	private String password;
	
	/**
	 * Description :登陆时对用户进行校验
	 * @param condition
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public String checkUser() throws Exception {
		
		//spring自动注入
		UserService userService = (UserService)getBean("userService");
		
		ResultMessage msg=userService.checkUserExist(username, password);
		
		if(!msg.isSuccess()) {
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
