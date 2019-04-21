package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.CustomerDao;
import com.neusoft.model.Customer;
import com.neusoft.service.CustomerService;
import com.neusoft.utils.Pager;


@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
    
     @Autowired
	 private CustomerDao customerDao;

	@Override
	public Pager<Customer> findPager(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findPager(customer);
	}


}