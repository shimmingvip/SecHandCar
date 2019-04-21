package com.neusoft.dao;

import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.CarCategory;
import com.neusoft.utils.Pager;

public interface CarCategoryDao extends BaseDao<CarCategory>{

    Pager<CarCategory> findPager(CarCategory carCategory);


}

