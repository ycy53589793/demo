package com.order.service;

import java.util.List;

import com.order.bean.Order;
import com.order.bean.OrderQueryCondition;

public interface OrderService {
	
	List<Order> getOrders(Integer pageNo,Integer pageSize);
	
	List<Order> getOrderByCondition(OrderQueryCondition queryCondition,Integer pageNo,Integer pageSize);
	
	Order saveOrder(Order order);

}
