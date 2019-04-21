package com.neusoft.dao.impl;



import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.CustomerDao;
import com.neusoft.model.Customer;



@Repository("customerDao")
@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	public Customer login(Customer customer) {
		String hql = "from Customer bean where bean.loginName =:loginName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("loginName", customer.getLoginName());
		q.setParameter("passWord", customer.getPassWord());
		return (Customer)q.uniqueResult();
	}

	@Override
	public Customer getByUserName(Customer customer) {
		String hql = "from Customer bean where bean.loginName =:loginName and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("loginName", customer.getLoginName());
		return (Customer)q.uniqueResult();
	}


}
