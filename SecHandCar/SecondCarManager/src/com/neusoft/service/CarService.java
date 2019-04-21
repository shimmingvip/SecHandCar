package com.neusoft.service;


import com.neusoft.model.Car;
import com.neusoft.utils.Pager;

public interface CarService  extends BaseService<Car>{

	Pager<Car> findPager(Car car);



}
