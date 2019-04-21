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
	public Pager<Bid> findPager(String cName) {
		if( cName!=null && !"".equals(cName !=null )){
	    	   String hql = "from Bid where customerName like :cName and isDelete=0 order by bidMoney desc ";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("cName", "%" +cName+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Bid where 1=1 and isDelete=0  order by bidMoney desc ";
				return findByAlias(hql, null);
	       }
	}


}
