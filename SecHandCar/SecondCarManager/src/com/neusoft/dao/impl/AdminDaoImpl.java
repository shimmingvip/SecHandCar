package com.neusoft.dao.impl;


import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.AdminDao;
import com.neusoft.model.Admin;
import com.neusoft.utils.Pager;



@Repository("adminDao")
@SuppressWarnings("unchecked")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	public Admin login(Admin admin) {
		String hql = "from Admin bean where bean.adminName =:adminName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("adminName", admin.getAdminName());
		q.setParameter("passWord", admin.getPassWord());
		return (Admin)q.uniqueResult();
	}

	@Override
	public Pager<Admin> findPager(Admin admin) {
		if(admin.getAdminName() !=null && !"".equals(admin.getAdminName() )){
	    	   String hql = "from Admin where adminName like :adminName  order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("adminName", "%" +admin.getAdminName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Admin where 1=1 order by id desc";
				return findByAlias(hql, null);
	       }
	}

	@Override
	public Admin getByUserName(Admin admin) {
		String hql = "from Admin bean where bean.adminName =:adminName and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("adminName", admin.getAdminName());
		return (Admin)q.uniqueResult();
	}



}
