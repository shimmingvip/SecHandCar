package com.neusoft.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.BidDao;
import com.neusoft.model.Bid;
import com.neusoft.utils.Pager;


@Repository("bidDao")
@SuppressWarnings("unchecked")
public class BidDaoImpl extends BaseDaoImpl<Bid> implements BidDao{

	@Override
	public Pager<Bid> findPager1(Integer userId) {
		 String hql = "from Bid where 1=1 and  customer.id =:userId";
		 Map<String,Object> alias = new HashMap<String,Object>();
		 alias.put("userId", userId);
			return findByAlias(hql, alias);
	}

}
