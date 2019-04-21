package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.OrderDao;
import com.neusoft.model.Order;
import com.neusoft.service.OrderService;
import com.neusoft.utils.Pager;


@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    
     @Autowired
	 private OrderDao orderDao;

	@Override
	public Pager<Order> findPager(Order order) {
		// TODO Auto-generated method stub
		return orderDao.findPager(order);
	}






}