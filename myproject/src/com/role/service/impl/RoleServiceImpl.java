package com.role.service.impl;

import java.util.List;
import java.util.Map;

import com.role.bean.Role;
import com.role.bean.RoleQueryCondition;
import com.role.dao.RoleDao;
import com.role.service.RoleService;
import com.util.EmptyUtil;
import com.util.SpringUtil;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<Role> getRoles(Integer pageNo, Integer pageSize) {
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		return roleDao.getRoles(pageNo, pageSize);
	}

	@Override
	public Role saveRole(Role role) {
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		if(EmptyUtil.isNull(role.getId())) {
			roleDao.save(role);
		}
		else {
			roleDao.update(role);
		}
		return role;
	}

	@Override
	public void deleteRole(Role role) {
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		roleDao.delete(role);
	}

	@Override
	public List<Role> getRoleByCondition(RoleQueryCondition queryCondition, Integer pageNo, Integer pageSize) {
		Map<String,Object> con = queryCondition.toMapCondition();
		con.put("pageNo", pageNo);
		con.put("pageSize", pageSize);
		
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		
		return roleDao.getRoles(con);
	}

	@Override
	public List<Role> getRoleByUserId(Integer userId) {
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		return roleDao.getRolesByUserId(userId);
	}

}
