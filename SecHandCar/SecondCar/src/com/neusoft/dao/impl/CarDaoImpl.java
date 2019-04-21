package com.neusoft.dao.impl;



import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.neusoft.base.dao.impl.BaseDaoImpl;
import com.neusoft.dao.CarDao;
import com.neusoft.model.Car;
import com.neusoft.utils.Pager;



@Repository("carDao")
@SuppressWarnings("unchecked")
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao{

    @Override
    public Pager<Car> findPager(Car car) {
            String hql = "from Car where 1=1";
             return findByAlias(hql, null);
    }

    @Override
    public Pager<Car> findPager1(Car car) {
            String hql = "from Car bean where 1=1 order by bean.carCategory.carLevel desc";
             return findByAlias(hql, null);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.neusoft.dao.ICarDao#listAll()
     */
    @Override
    public Pager<Car> listAll() {
        String hql = "from Car where 1=1 ";
        Map<String,Object> alias = new HashMap<String,Object>();
        return findByAlias(hql, null);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.neusoft.dao.ICarDao#listByName(java.lang.String)
     */
    @Override
    public Pager<Car> listByName(String keyword) {
        String hql = "from Car where carCategory.cname like :keyword ";
        Map<String,Object> alias = new HashMap<String,Object>();
        alias.put("keyword", "%" + keyword + "%");
        return findByAlias(hql, alias);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.neusoft.dao.ICarDao#listByNameAndprice(java.lang.String, java.lang.String)
     */
    @Override
    public Pager<Car> listByNameAndprice(String keyword, String carPrice) {
        String hql = "from Car where carCategory.cname like :keyword and  carPrice like :carPrice ";
        Map<String,Object> alias = new HashMap<String,Object>();
        alias.put("keyword", "%" + keyword + "%");
        alias.put("carPrice", "%" + carPrice + "%");
        return findByAlias(hql, alias);
    }

	

//	@Override
//	public List<Car> getByCarId(int i) {
//        String hql = "from Car bean where bean.carCategory.id= :i ";
//        Query q =this.getSession().createQuery(hql);
//        q.setParameter("i", i);
//        return q.list();
//	}


//    @Override
//    public void merger(Car car) {
//        // TODO Auto-generated method stub
//    	this.getSession().merge(car);
//        this.getSession().update(car);
//    }


}
