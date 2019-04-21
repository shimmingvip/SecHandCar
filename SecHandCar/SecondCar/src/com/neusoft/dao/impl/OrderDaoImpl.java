package com.neusoft.dao.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.OrderDao;
import com.neusoft.model.Order;
import com.neusoft.utils.Pager;



@Repository("orderDao")
@SuppressWarnings("unchecked")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

	@Override
	public Pager<Order> findPager(Order order) {
		if(order.getCode() !=null && !"".equals(order.getCode() )){
	    	   String hql = "from Order where code like :code order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("code", "%" +order.getCode()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Order where 1=1 order by id desc";
				return findByAlias(hql, null);
	       }
	}
  

}
