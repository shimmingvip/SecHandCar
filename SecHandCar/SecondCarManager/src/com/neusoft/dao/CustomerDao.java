package com.neusoft.dao;



import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Customer;
import com.neusoft.utils.Pager;

public interface CustomerDao extends BaseDao<Customer>{


	Pager<Customer> findPager(Customer customer);



}

