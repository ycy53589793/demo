package com.order.service.impl;

import java.util.List;
import java.util.Map;

import com.order.bean.Order;
import com.order.bean.OrderQueryCondition;
import com.order.dao.OrderDao;
import com.order.service.OrderService;
import com.util.SpringUtil;

public class OrderServiceImpl implements OrderService {
	
	public List<Order> getOrders(Integer pageNo,Integer pageSize) {
		OrderDao orderDao = (OrderDao) SpringUtil.getBean("orderDao");
		return orderDao.getOrders(pageNo,pageSize);
	}
	
	public List<Order> getOrderByCondition(OrderQueryCondition queryCondition,Integer pageNo,Integer pageSize) {
		Map<String,Object> con = queryCondition.toMapCondition();
		con.put("pageNo", pageNo);
		con.put("pageSize", pageSize);
		
		OrderDao orderDao = (OrderDao) SpringUtil.getBean("orderDao");
		
		return orderDao.getOrders(con);
	}
	
	public Order saveOrder(Order order) {
		OrderDao orderDao = (OrderDao) SpringUtil.getBean("orderDao");
		orderDao.save(order);
		return order;
	}

}
