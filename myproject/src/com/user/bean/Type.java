package com.user.bean;

/**
 * AbstractType entity provides the base persistence definition of the Type
 * entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1362138907962988777L;
	// Fields

	private Integer id;
	private String typeName;

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String typeName) {
		this.typeName = typeName;
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

}