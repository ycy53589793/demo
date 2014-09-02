package com.role.service;

import java.util.List;

import com.role.bean.Role;
import com.role.bean.RoleQueryCondition;

public interface RoleService {
	
	List<Role> getRoles(Integer pageNo,Integer pageSize);
	
	Role saveRole(Role role);
	
	void deleteRole(Role role);
	
	List<Role> getRoleByCondition(RoleQueryCondition queryCondition,Integer pageNo,Integer pageSize);

}
