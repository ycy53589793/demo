package com.order.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.common.PageAction;
import com.order.bean.Order;
import com.order.bean.OrderQueryCondition;
import com.order.service.OrderService;
import com.util.SpringUtil;

public class OrderAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3044009783035775912L;
	
	private JSONObject jsonOrders;
	private OrderQueryCondition orderQuery;
	
	public String getOrders() {
		
		OrderService orderService = (OrderService) SpringUtil.getBean("orderService");
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
		
		OrderService orderService = (OrderService) SpringUtil.getBean("orderService");
		//获取订单
		List<Order> orders = orderService.getOrderByCondition(orderQuery, pageNo, pageSize);
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

	public JSONObject getJsonOrders() {
		return jsonOrders;
	}
	public void setJsonOrders(JSONObject jsonOrders) {
		this.jsonOrders = jsonOrders;
	}

	public OrderQueryCondition getOrderQuery() {
		return orderQuery;
	}
	public void setOrderQuery(OrderQueryCondition orderQuery) {
		this.orderQuery = orderQuery;
	}

}
