package com.order.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.common.PageAction;
import com.order.bean.Order;
import com.order.bean.OrderQueryCondition;
import com.order.service.OrderService;

public class OrderAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3044009783035775912L;
	
	private OrderService orderService;
	private JSONObject jsonOrders;
	private OrderQueryCondition orderQuery;
	
	public String getOrders() {
		
		//获取订单
		List<Order> orders = orderService.getOrders(pageNo,pageSize);
		//转成json
		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("rows", orders);
		orderMap.put("total", orders.size());
		try {
			jsonOrders=JSONObject.fromObject(orderMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return JSON;
		
	}
	
	public String getOrderByCondition() {
		
		return JSON;
		
	}

	public JSONObject getJsonOrders() {
		return jsonOrders;
	}
	public void setJsonOrders(JSONObject jsonOrders) {
		this.jsonOrders = jsonOrders;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderQueryCondition getOrderQuery() {
		return orderQuery;
	}
	public void setOrderQuery(OrderQueryCondition orderQuery) {
		this.orderQuery = orderQuery;
	}

}
