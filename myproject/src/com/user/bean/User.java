package com.user.bean;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 7290115891434329597L;

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Type type, Role role, Org org, String sex, String enable,
			String phone, Date birthday, String professional, String sign,
			String detail, String interest, String school, Integer credit,
			String username, String password) {
		super(type, role, org, sex, enable, phone, birthday, professional,
				sign, detail, interest, school, credit, username, password);
	}

}
