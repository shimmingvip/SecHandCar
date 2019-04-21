package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.CarDao;
import com.neusoft.model.Car;
import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;


@Service("carService")
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {
    
     @Autowired
	 private CarDao carDao;

	@Override
	public Pager<Car> findPager(Car car) {
		// TODO Auto-generated method stub
		return carDao.findPager(car);
	}



}