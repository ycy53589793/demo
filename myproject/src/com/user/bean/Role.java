package com.user.bean;

import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
public class Role extends AbstractRole implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 5604041261179731776L;

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(Org org, String roleName, Set<User> users) {
		super(org, roleName, users);
	}

}
