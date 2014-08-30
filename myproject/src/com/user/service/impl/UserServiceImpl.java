package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constant.Constant;
import com.user.bean.User;
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
	public ResultMessage checkUserExist(String username, String password) {
		
		User user = findUserByUserNameAndPassword(username,password);
		
		ResultMessage msg = new ResultMessage();
		msg.setSuccess(false);
		
		if(EmptyUtil.isNotNull(user)) {
			msg.setSuccess(true);
			msg.setResultDate(user);
			return msg;
		}
		
		return msg;
		
	}
	
	@SuppressWarnings("rawtypes")
	public User findUserByUserNameAndPassword(String username,String password) {
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("username", username);
		condition.put("password", password);
		
		List res=userDao.queryByCondition(condition);
		
		if(EmptyUtil.isNotEmpty(res) && res.size()==Constant.NUMBER.ONE) {
			return (User) res.get(0);
		}
		
		return null;
		
	}
	
	public User getUserById(Integer userId) {
		return (User) userDao.queryById(userId, User.class);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
