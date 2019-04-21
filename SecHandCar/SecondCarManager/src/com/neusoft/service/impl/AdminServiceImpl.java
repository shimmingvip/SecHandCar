package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.AdminDao;
import com.neusoft.model.Admin;
import com.neusoft.service.AdminService;
import com.neusoft.utils.Pager;


@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    
     @Autowired
	 private AdminDao adminDao;

	@Override
	public Admin login(Admin admin) {
	 Admin ad = new Admin();
	 ad.setAdminName(admin.getAdminName());
	 ad.setPassWord(admin.getPassWord());
	return adminDao.login(ad);
}

     
	@Override
	public Pager<Admin> findPager(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findPager(admin);
	}


	@Override
	public Admin getByUserName(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.getByUserName(admin);
	}

}