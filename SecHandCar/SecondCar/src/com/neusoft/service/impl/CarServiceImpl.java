package com.neusoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;
import com.neusoft.dao.CarDao;
import com.neusoft.model.Car;


@Service("carService")
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {
    
     @Autowired
	 private CarDao carDao;

    @Override
    public Pager<Car> findPager(Car car) {
        // TODO Auto-generated method stub
        return carDao.findPager(car);
    }

    @Override
    public Pager<Car> findPager1(Car car) {
        // TODO Auto-generated method stub
        return carDao.findPager1(car);
    }

  
    @Override
    public Pager<Car> findPager2(String keyword,String carPrice) {
        // TODO Auto-generated method stub
        if(("-1").equals(carPrice)||carPrice==null){
            if(keyword == null || "".equals(keyword)){
                return carDao.listAll();
            }else{
                return carDao.listByName(keyword);
            }
        }else{
        if(!("-1").equals(carPrice)){
            return carDao.listByNameAndprice(keyword,carPrice);
        }else{
             return carDao.listByName(keyword);
          }
       }
    }



//    @Override
//    public void updateInfo(Car car) {
//        // TODO Auto-generated method stub
//        //carDao.update(car);
//    	
//        carDao.merger(car);
//    }


}