package com.neusoft.dao;

import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Bid;
import com.neusoft.utils.Pager;

public interface BidDao extends BaseDao<Bid>{

	Pager<Bid> findPager(String cName);





}
