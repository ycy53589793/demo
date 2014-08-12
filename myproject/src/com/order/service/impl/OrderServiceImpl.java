package com.order.service.impl;

import java.util.List;

import com.order.bean.Order;
import com.order.dao.OrderDao;
import com.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
