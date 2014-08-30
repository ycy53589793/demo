package com.filter;

import java.io.Serializable;
import java.util.Set;

import com.user.bean.Role;

public class ShiroUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3349321560055822391L;
	public Integer id;
    public String username;
    public Set<Role> roles;
    
    public ShiroUser(Integer id, String username, Set<Role> roles) {
        this.id = id;
        this.roles = roles;
        this.username = username;
    }

}
