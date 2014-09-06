package com.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import com.BaseAction;
import com.common.bean.ShiroUser;
import com.opensymphony.xwork2.Action;
import com.util.EmptyUtil;

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
		
		//从session中获取登录用户信息
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		//如果登录用户不为空,用户已经登录过,直接返回成功
		if(EmptyUtil.isNotNull(user) && EmptyUtil.isNotEmpty(user.username)) {
			return Action.SUCCESS;
		}
		else {
			//判断用户名 密码
			if(EmptyUtil.isEmpty(username) || EmptyUtil.isEmpty(password)) {
				return Action.ERROR;
			}
			else {
				//shiro安全框架验证用户是否合法
				UsernamePasswordToken token = new UsernamePasswordToken(username,password);
				try {
					currentUser.login(token);
				}catch(Exception e) {
					e.printStackTrace();
					//登录失败
					return Action.ERROR;
				}
			}
		}
		
//		if(EmptyUtil.isEmpty(username) || EmptyUtil.isEmpty(password)) {
//			username = (String) strutsSession.get(Constant.STRING.USERNAME);
//			password = (String) strutsSession.get(Constant.STRING.PASSWORD);
//		}
//		if(EmptyUtil.isEmpty(username) || EmptyUtil.isEmpty(password)) {
//			return Action.ERROR;
//		}
//		
//		//spring自动注入
//		UserService userService = (UserService) SpringUtil.getBean("userService");
//		
//		ResultMessage msg=userService.checkUserExist(username, password);
//		
//		if(!msg.isSuccess()) {
//			return Action.ERROR;
//		}
		
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
