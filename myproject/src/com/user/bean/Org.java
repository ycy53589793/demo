package com.user.bean;

import java.util.Set;

/**
 * Org entity. @author MyEclipse Persistence Tools
 */
public class Org extends AbstractOrg implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4867588571224515498L;

	/** default constructor */
	public Org() {
	}

	/** full constructor */
	public Org(String orgName, Set<Role> roles, Set<User> users) {
		super(orgName, roles, users);
	}

}
