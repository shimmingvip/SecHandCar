package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.CarCategoryDao;
import com.neusoft.model.CarCategory;
import com.neusoft.service.CarCategoryService;
import com.neusoft.utils.Pager;


@Service("carCategoryService")
public class CarCategoryServiceImpl extends BaseServiceImpl<CarCategory> implements CarCategoryService {
    
     @Autowired
	 private CarCategoryDao carCategoryDao;

	@Override
	public Pager<CarCategory> findPager(CarCategory carCategory) {
		// TODO Auto-generated method stub
		return carCategoryDao.findPager(carCategory);
	}



}