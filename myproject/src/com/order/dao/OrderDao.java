package com.order.dao;

import java.util.List;
import java.util.Map;

import com.BaseDao;
import com.order.bean.Order;
import com.template.dao.HibernateTemplateDao;
import com.util.EmptyUtil;
import com.util.SpringUtil;

public class OrderDao extends BaseDao {
	
	public List<Order> getOrders() {
		return getOrders(null,null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders(Integer pageNo,Integer pageSize) {
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			return queryByPageInfo(Order.class, pageNo, pageSize);
		}
		else {
			return (List<Order>)searchAll(Order.class);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders(Map<String,Object> conMap) {
		if(EmptyUtil.isNull(hibernateTemplateDao)) {
			hibernateTemplateDao = (HibernateTemplateDao) SpringUtil.getBean("hibernateTemplateDao");
		}
		return hibernateTemplateDao.findByNamedQuery("order.queryByCondition", conMap);
	}

}
