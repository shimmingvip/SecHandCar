package com.neusoft.dao.impl;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.CustomerDao;
import com.neusoft.model.Customer;
import com.neusoft.utils.Pager;


@Repository("customerDao")
@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	public Pager<Customer> findPager(Customer customer) {
		if(customer.getCustomerName() !=null && !"".equals(customer.getCustomerName() )){
	    	   String hql = "from Customer where customerName like :customerName order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("customerName", "%" +customer.getCustomerName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Customer where 1=1 order by id desc";
				return findByAlias(hql, null);
	       }
	}


}
