package com.neusoft.dao;



import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Order;
import com.neusoft.utils.Pager;

public interface OrderDao extends BaseDao<Order>{

	Pager<Order> findPager(Order order);



}

