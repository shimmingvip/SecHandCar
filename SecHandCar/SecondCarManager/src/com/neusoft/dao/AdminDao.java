package com.neusoft.dao;



import com.neusoft.base.dao.BaseDao;
import com.neusoft.model.Admin;
import com.neusoft.utils.Pager;

public interface AdminDao extends BaseDao<Admin>{

	Admin login(Admin ad);

	Pager<Admin> findPager(Admin admin);

	Admin getByUserName(Admin admin);



}
