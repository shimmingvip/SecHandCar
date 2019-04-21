package com.neusoft.service;

import com.neusoft.model.Order;
import com.neusoft.utils.Pager;

public interface OrderService  extends BaseService<Order>{

	Pager<Order> findPager(Order order);

	Pager<Order> findPager1(Order order);

   



}
