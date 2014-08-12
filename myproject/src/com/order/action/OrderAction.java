package com.order.action;

import java.util.List;

import com.BaseAction;
import com.order.bean.Order;
import com.order.service.OrderService;

public class OrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3044009783035775912L;
	
	private OrderService orderService;
	
	public List<Order> getOrders() {
		
		orderService = (OrderService) getBean("orderService");
		
		return orderService.getOrders();
		
	}

}
