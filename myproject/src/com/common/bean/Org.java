package com.common.bean;

/**
 * AbstractOrg entity provides the base persistence definition of the Org
 * entity. @author MyEclipse Persistence Tools
 */

public class Org implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2981853822592483928L;
	private Integer id;
	private String orgName;

	// Constructors

	/** default constructor */
	public Org() {
	}

	/** full constructor */
	public Org(String orgName) {
		this.orgName = orgName;
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

}