package com.neusoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.CustomerDao;
import com.neusoft.model.Customer;
import com.neusoft.service.CustomerService;


@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
    
     @Autowired
	 private CustomerDao customerDao;

	@Override
	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.login(customer);
	}

	@Override
	public Customer getByUserName(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.getByUserName(customer);
	}

}