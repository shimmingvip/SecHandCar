package com.neusoft.service;

import com.neusoft.model.Bid;
import com.neusoft.utils.Pager;

public interface BidService  extends BaseService<Bid>{

	Pager<Bid> findPager(String cName);





}
