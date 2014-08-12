package com.order.service.impl;

import java.util.List;

import com.order.bean.Order;
import com.order.dao.OrderDao;
import com.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public List<Order> getOrders(Integer pageNo,Integer pageSize) {
		return orderDao.getOrders(pageNo,pageSize);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
