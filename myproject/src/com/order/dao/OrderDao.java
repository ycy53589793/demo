package com.order.dao;

import java.util.List;

import com.BaseDao;
import com.order.bean.Order;
import com.util.EmptyUtil;

public class OrderDao extends BaseDao {

	public List<Order> getOrders() {
		return getOrders(null,null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders(Integer pageNo,Integer pageSize) {
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			return queryByPageInfo(Order.class, pageNo, pageSize);
		}
		else {
			return (List<Order>)searchAll(Order.class);
		}
	}

}
