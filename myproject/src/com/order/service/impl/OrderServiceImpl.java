package com.order.service.impl;

import java.util.List;

import com.BaseServiceImpl;
import com.order.bean.Order;
import com.order.dao.OrderDao;
import com.order.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public List<Order> getOrders() {
		orderDao = (OrderDao) getBean("orderDao");
		return orderDao.getOrders();
	}

}
