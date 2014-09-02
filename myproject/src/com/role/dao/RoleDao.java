package com.role.dao;

import java.util.List;
import java.util.Map;

import com.BaseDao;
import com.role.bean.Role;
import com.template.dao.HibernateTemplateDao;
import com.util.EmptyUtil;
import com.util.SpringUtil;

public class RoleDao extends BaseDao {
	
	@SuppressWarnings("unchecked")
	public List<Role> getRoles(Integer pageNo,Integer pageSize) {
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			return queryByPageInfo(Role.class, pageNo, pageSize);
		}
		else {
			return (List<Role>) searchAll(Role.class);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRoles(Map<String,Object> con) {
		if(EmptyUtil.isNull(hibernateTemplateDao)) {
			hibernateTemplateDao = (HibernateTemplateDao) SpringUtil.getBean("hibernateTemplateDao");
		}
		return hibernateTemplateDao.findByNamedQuery("role.queryByCondition", con);
	}

}
