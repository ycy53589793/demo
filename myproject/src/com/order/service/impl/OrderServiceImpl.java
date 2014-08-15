package com.order.service.impl;

import java.util.List;

import com.order.bean.Order;
import com.order.bean.OrderQueryCondition;
import com.order.dao.OrderDao;
import com.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public List<Order> getOrders(Integer pageNo,Integer pageSize) {
		return orderDao.getOrders(pageNo,pageSize);
	}
	
	public List<Order> getOrderByCondition(OrderQueryCondition queryCondition,Integer pageNo,Integer pageSize) {
		return null;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
