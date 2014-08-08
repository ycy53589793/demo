package com.user.bean;

import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */
public class Type extends AbstractType implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 6653071627029615045L;

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String typeName, Set<User> users) {
		super(typeName, users);
	}

}
