package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.BidDao;
import com.neusoft.model.Bid;
import com.neusoft.service.BidService;
import com.neusoft.utils.Pager;


@Service("bidService")
public class BidServiceImpl extends BaseServiceImpl<Bid> implements BidService {
    
     @Autowired
	 private BidDao bidDao;

	@Override
	public Pager<Bid> findPager(String cName) {
		// TODO Auto-generated method stub
		return bidDao.findPager(cName);
	}
     




}