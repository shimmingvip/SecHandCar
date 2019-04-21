package com.neusoft.service;


import com.neusoft.model.Customer;

public interface CustomerService  extends BaseService<Customer>{

	Customer login(Customer customer);

	Customer getByUserName(Customer customer);


}
