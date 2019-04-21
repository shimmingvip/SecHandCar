package com.neusoft.service;

import com.neusoft.model.Admin;
import com.neusoft.utils.Pager;

public interface AdminService  extends BaseService<Admin>{

	Admin login(Admin admin);

	Pager<Admin> findPager(Admin admin);

	Admin getByUserName(Admin admin);


}
