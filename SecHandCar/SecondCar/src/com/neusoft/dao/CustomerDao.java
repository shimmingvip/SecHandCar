package com.neusoft.dao;



import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	Customer login(Customer customer);

	Customer getByUserName(Customer customer);



}

