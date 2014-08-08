package com.user.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -152225785184899669L;
	private Integer id;
	private Org org;
	private String roleName;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** full constructor */
	public AbstractRole(Org org, String roleName, Set<User> users) {
		this.org = org;
		this.roleName = roleName;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}