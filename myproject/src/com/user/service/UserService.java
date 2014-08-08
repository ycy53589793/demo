package com.user.service;

import com.util.ResultMessage;

public interface UserService {
	
	/**
	 * Description :校验用户是否存在
	 * @param username,password
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	ResultMessage checkUserExist(String username, String password);

}
