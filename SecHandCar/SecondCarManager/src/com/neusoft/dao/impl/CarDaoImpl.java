package com.neusoft.dao.impl;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.CarDao;
import com.neusoft.model.Car;
import com.neusoft.utils.Pager;



@Repository("carDao")
@SuppressWarnings("unchecked")
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao{

	@Override
	public Pager<Car> findPager(Car car) {
		if(car.getCarName() !=null && !"".equals(car.getCarName() )){
	    	   String hql = "from Car where carName like :carName order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("carName", "%" +car.getCarName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Car where 1=1 order by id desc";
				return findByAlias(hql, null);
	       }
	}



}
