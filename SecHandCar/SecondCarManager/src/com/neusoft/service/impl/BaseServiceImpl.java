package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.base.dao.BaseDao;
import com.neusoft.service.BaseService;

public class  BaseServiceImpl<T> implements BaseService<T>{
	/** 
     * 注入BaseDao 
     */  
	@Autowired
    private BaseDao<T> dao;  

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void save(T entity) {
		dao.add(entity);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public T getById(int id) {
		return dao.load(id);
	}

	public List<T> getByHQL(String hql, Map<String, Object> alias) {
		return  dao.listByAlias(hql, alias);
	}

	@Override
	public T getOneByHql(String hql, Map<String, Object> alias) {
		return dao.getByParams(hql,alias);
	}

}
