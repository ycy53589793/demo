package com.role.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.common.PageAction;
import com.role.bean.Role;
import com.role.bean.RoleQueryCondition;
import com.role.service.RoleService;
import com.util.SpringUtil;

public class RoleAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2530772528524457315L;
	
	private Role role;
	private JSONObject jsonRoles;
	private RoleQueryCondition roleQuery;
	
	public String getRoles() {
		
		RoleService roleService = (RoleService) SpringUtil.getBean("roleService");
		//获取角色
		List<Role> roles = roleService.getRoles(pageNo, pageSize);
		//转成json
		Map<String, Object> roleMap = new HashMap<String, Object>();
		roleMap.put("rows", roles);
		roleMap.put("total", roles.size());
		try {
			jsonRoles=JSONObject.fromObject(roleMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	public String addRole() {
		return saveRole();
	}
	
	public String updateRole() {
		return saveRole();
	}
	
	public String deleteRole() {
		RoleService roleService = (RoleService) SpringUtil.getBean("roleService");
		roleService.deleteRole(role);
		return JSON;
	}
	
	public String getRoleByCondition() {
		
		RoleService roleService = (RoleService) SpringUtil.getBean("roleService");
		List<Role> roles = roleService.getRoleByCondition(roleQuery, pageNo, pageSize);
		//转成json
		Map<String,Object> roleMap = new HashMap<String,Object>();
		roleMap.put("rows", roles);
		roleMap.put("total", roles.size());
		try {
			jsonRoles=JSONObject.fromObject(roleMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return JSON;
	}
	
	private String saveRole() {
		RoleService roleService = (RoleService) SpringUtil.getBean("roleService");
		roleService.saveRole(role);
		//转成json
		try {
			jsonRoles=JSONObject.fromObject(role);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return JSON;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public RoleQueryCondition getRoleQuery() {
		return roleQuery;
	}
	public void setRoleQuery(RoleQueryCondition roleQuery) {
		this.roleQuery = roleQuery;
	}
	public JSONObject getJsonRoles() {
		return jsonRoles;
	}
	public void setJsonRoles(JSONObject jsonRoles) {
		this.jsonRoles = jsonRoles;
	}

}
