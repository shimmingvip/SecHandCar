package com.neusoft.service;

import com.neusoft.model.CarCategory;
import com.neusoft.utils.Pager;

public interface CarCategoryService  extends BaseService<CarCategory>{

   
    Pager<CarCategory> findPager(CarCategory carCategory);


}
