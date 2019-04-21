package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.CarCustomerDao;
import com.neusoft.model.CarCustomer;
import com.neusoft.service.CarCustomerService;


@Service("carCustomerService")
public class CarCustomerServiceImpl extends BaseServiceImpl<CarCustomer> implements CarCustomerService {
    
     @Autowired
	 private CarCustomerDao carCustomerDao;




}