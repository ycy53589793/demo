package com.role.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.BaseCondition;
import com.common.bean.Org;
import com.user.bean.User;
import com.util.EmptyUtil;

public class RoleQueryCondition extends BaseCondition implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -152225785184899669L;
	private Integer id;
	private Org org;
	private String roleName;
	private Set<User> users = new HashSet<User>(0);


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
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public Map<String, Object> toMapCondition() {
		Map<String,Object> condition = new HashMap<String, Object>();
		if(EmptyUtil.isNotEmpty(id)) {
			condition.put("id", id);
		}
		if(EmptyUtil.isNotEmpty(roleName)) {
			condition.put("roleName", roleName);
		}
		if(EmptyUtil.isNotNull(org) && EmptyUtil.isNotNull(org.getId())) {
			condition.put("orgId", org.getId());
		}
		return condition;
	}

}