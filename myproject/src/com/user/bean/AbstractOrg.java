package com.user.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractOrg entity provides the base persistence definition of the Org
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2981853822592483928L;
	private Integer id;
	private String orgName;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public AbstractOrg() {
	}

	/** full constructor */
	public AbstractOrg(String orgName, Set<Role> roles, Set<User> users) {
		this.orgName = orgName;
		this.roles = roles;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}