package com.neusoft.service;


import com.neusoft.model.Car;
import com.neusoft.utils.Pager;

public interface CarService  extends BaseService<Car>{

    Pager<Car> findPager(Car car);

    Pager<Car> findPager1(Car car);

    Pager<Car> findPager2(String keyword, String carPrice);



//    void updateInfo(Car car);


}
