package com.order.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.BaseDao;
import com.order.bean.Order;
import com.util.EmptyUtil;
import com.util.HibernateUtil;

public class OrderDao extends BaseDao {

	@SuppressWarnings("rawtypes")
	public List queryByCondition(Map<String, Object> condition) {
		//获取session
		Session session=HibernateUtil.getSession();
		//构造查询条件
		Criteria criteria=session.createCriteria(Order.class);
		if(EmptyUtil.isNotNull(condition)) {
			Set<String> keys=condition.keySet();
			for(String key:keys) {
				criteria.add(Restrictions.eq(key,condition.get(key)));
			}
		}
		//查询
		List res=criteria.list();
		//关闭session
		HibernateUtil.closeSession(session);
		//返回
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return (List<Order>)queryByCondition(null);
	}

}
