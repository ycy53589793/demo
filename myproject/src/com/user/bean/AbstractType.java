package com.user.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractType entity provides the base persistence definition of the Type
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1362138907962988777L;
	// Fields

	private Integer id;
	private String typeName;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public AbstractType() {
	}

	/** full constructor */
	public AbstractType(String typeName, Set<User> users) {
		this.typeName = typeName;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}