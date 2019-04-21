package com.neusoft.dao;



import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Car;
import com.neusoft.utils.Pager;

public interface CarDao extends BaseDao<Car>{

    
    Pager<Car> findPager(Car car);

    Pager<Car> findPager1(Car car);

    Pager<Car> listAll();

    Pager<Car> listByName(String keyword);

    Pager<Car> listByNameAndprice(String keyword, String carPrice);


//    void merger(Car car);


}

