package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constant.Constant;
import com.user.dao.UserDao;
import com.user.service.UserService;
import com.util.EmptyUtil;
import com.util.ResultMessage;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	/**
	 * Description :校验用户是否存在
	 * @param username,password
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	@SuppressWarnings("rawtypes")
	public ResultMessage checkUserExist(String username, String password) {
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("username", username);
		condition.put("password", password);
		
		List res=userDao.queryByCondition(condition);
		
		ResultMessage msg = new ResultMessage();
		msg.setSuccess(false);
		
		if(EmptyUtil.isNotEmpty(res) && res.size()==Constant.NUMBER.ONE) {
			msg.setSuccess(true);
			msg.setResultDate(res.get(0));
			return msg;
		}
		
		return msg;
		
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
