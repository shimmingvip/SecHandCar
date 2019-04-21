package com.neusoft.dao.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.CarCategoryDao;
import com.neusoft.model.CarCategory;
import com.neusoft.utils.Pager;



@Repository("carCategoryDao")
@SuppressWarnings("unchecked")
public class CarCategoryDaoImpl extends BaseDaoImpl<CarCategory> implements CarCategoryDao{

    @Override
    public Pager<CarCategory> findPager(CarCategory carCategory) {
        if(carCategory.getCname() !=null && !"".equals(carCategory.getCname() )){
            String hql = "from CarCategory where cname = :cname  order by id desc";
            Map<String,Object> alias = new HashMap<String,Object>();
            alias.put("cname", carCategory.getCname() );
           return findByAlias(hql, alias);
        }else{
            String hql = "from CarCategory where 1=1 order by id desc";
             return findByAlias(hql, null);
        }
    }




}
