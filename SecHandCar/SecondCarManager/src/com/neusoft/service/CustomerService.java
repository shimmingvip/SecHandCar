package com.neusoft.service;


import com.neusoft.model.Customer;
import com.neusoft.utils.Pager;

public interface CustomerService  extends BaseService<Customer>{

	Pager<Customer> findPager(Customer customer);


}
