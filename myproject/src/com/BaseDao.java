package com;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.template.dao.HibernateTemplateDao;
import com.util.EmptyUtil;
import com.util.HibernateUtil;
import com.util.SpringUtil;

/**
 * Description:   基础dao类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public abstract class BaseDao {
	
	protected HibernateTemplateDao hibernateTemplateDao;
	
	/**
	 * Description :
	 * @param id
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public Object queryById(Integer id,Class<?> clazz) {
		Session session = HibernateUtil.getSession();
		Object obj = session.load(clazz,id);
		return obj;
	}
	
	/**
	 * Description :
	 * @param ids
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByIds(Integer ids[],Class<?> clazz) {
		if(EmptyUtil.isNotNull(ids) && EmptyUtil.isNotEmpty(ids)) {
			return queryByIds(Arrays.asList(ids),clazz);
		}
		return null;
	}
	
	/**
	 * Description :
	 * @param ids
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByIds(List<Integer> ids,Class<?> clazz) {
		if(EmptyUtil.isEmpty(ids)) {
			return null;
		}
		String hql = "from "+clazz.getSimpleName()+" where id in(";
		for(int i=0;i<ids.size();i++) {
			if(i==0) {
				hql += ids.get(i);
			}
			else {
				hql += ","+ids.get(i);
			}
		}
		hql += ")";
		if(EmptyUtil.isNull(hibernateTemplateDao)) {
			hibernateTemplateDao = (HibernateTemplateDao) SpringUtil.getBean("hibernateTemplateDao");
		}
		return hibernateTemplateDao.queryByHQL(hql);
	}
	
	/**
	 * Description :
	 * @param id
	 * @param clazz
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void deleteById(Long id,Class<?> clazz) {
		try {
			Field field=clazz.getField("id");
			Object obj=clazz.newInstance();
			field.setAccessible(true);
			field.set(obj, id);
			delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Description :
	 * @param ids
	 * @param clazz
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void deleteByIds(Integer ids[],Class<?> clazz) {
		if(EmptyUtil.isNotNull(ids) && EmptyUtil.isNotEmpty(ids)) {
			deleteByIds(Arrays.asList(ids),clazz);
		}
	}
	
	/**
	 * Description :
	 * @param ids
	 * @param clazz
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void deleteByIds(List<Integer> ids,Class<?> clazz) {
		if(EmptyUtil.isEmpty(ids)) {
			return;
		}
		String hql = "delete from "+clazz.getSimpleName()+" where id in(";
		for(int i=0;i<ids.size();i++) {
			if(i==0) {
				hql += ids.get(i);
			}
			else {
				hql += ","+ids.get(i);
			}
		}
		hql += ")";
		if(EmptyUtil.isNull(hibernateTemplateDao)) {
			hibernateTemplateDao = (HibernateTemplateDao) SpringUtil.getBean("hibernateTemplateDao");
		}
		hibernateTemplateDao.deleteByHQL(hql);
	}
	
	/**
	 * Description :
	 * @param condition
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByCondition(Map<String,Object> condition,Class<?> clazz) {
		return queryByCondition(condition,clazz,null,null);
	}
	
	/**
	 * Description :
	 * @param condition
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByCondition(Map<String, Object> condition,Class<?> clazz,Integer pageNo,Integer pageSize) {
		//获取session
		Session session=HibernateUtil.getSession();
		//构造查询条件
		Criteria criteria=session.createCriteria(clazz);
		if(EmptyUtil.isNotNull(condition)) {
			Set<String> keys=condition.keySet();
			for(String key:keys) {
				criteria.add(Restrictions.eq(key,condition.get(key)));
			}
		}
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			criteria.setFirstResult(pageSize*(pageNo-1));
			criteria.setMaxResults(pageSize);
		}
		//查询
		List res=criteria.list();
		//关闭session
		HibernateUtil.closeSession(session);
		//返回
		return res;
	}
	
	/**
	 * Description :
	 * @param obj
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void save(Object obj) {
		Session s=HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		s.save(obj);
		tx.commit();
		HibernateUtil.closeSession(s);
	}
	
	/**
	 * Description :
	 * @param objs
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void saveAll(List<Object> objs) {
		if(EmptyUtil.isNotEmpty(objs)) {
			Session s=HibernateUtil.getSession();
			Transaction tx=s.beginTransaction();
			for(Object obj:objs) {
				s.save(obj);
			}
			tx.commit();
			HibernateUtil.closeSession(s);
		}
	}
	
	/**
	 * Description :
	 * @param obj
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void delete(Object obj) {
		Session s=HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		s.delete(obj);
		tx.commit();
		HibernateUtil.closeSession(s);
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryAll(Class<?> clazz) {
		return queryByPageInfo(clazz,null,null);
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByPageInfo(Class<?> clazz,Integer pageNo,Integer pageSize) {
		Session session=HibernateUtil.getSession();
		Criteria c=session.createCriteria(clazz);
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			c.setFirstResult(pageSize*(pageNo-1));
			c.setMaxResults(pageSize);
		}
		List res=c.list();
		HibernateUtil.closeSession(session);
		return res;
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public Iterator searchAll(Class<?> clazz) {
		return searchByPageInfo(clazz,null,null);
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public Iterator searchByPageInfo(Class<?> clazz,Integer pageNo,Integer pageSize) {
		Session session=HibernateUtil.getSession();
		String hql="from "+clazz.getName();
		Query q=session.createQuery(hql);
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			q.setFirstResult(pageSize*(pageNo-1));
			q.setMaxResults(pageSize);
		}
		Iterator ite=q.iterate();
		HibernateUtil.closeSession(session);
		return ite;
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List findAll(Class<?> clazz) {
		return findByPageInfo(clazz,null,null);
	}
	
	/**
	 * Description :
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List findByPageInfo(Class<?> clazz,Integer pageNo,Integer pageSize) {
		Session session=HibernateUtil.getSession();
		String hql="from "+clazz.getName();
		Query q=session.createQuery(hql);
		if(EmptyUtil.isNotEmpty(pageNo) && EmptyUtil.isNotEmpty(pageSize)) {
			q.setFirstResult(pageSize*(pageNo-1));
			q.setMaxResults(pageSize);
		}
		List res=q.list();
		HibernateUtil.closeSession(session);
		return res;
	}
	
	/**
	 * Description :查询总记录数
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-6-8
	 */
	public long getCount(Class<?> clazz) {
		Session session=HibernateUtil.getSession();
		Criteria c=session.createCriteria(clazz);
		c.setProjection(Projections.rowCount());
		long totalRecords=Long.parseLong(c.uniqueResult().toString());
		HibernateUtil.closeSession(session);
		return totalRecords;
	}

	public HibernateTemplateDao getHibernateTemplateDao() {
		return hibernateTemplateDao;
	}
	public void setHibernateTemplateDao(HibernateTemplateDao hibernateTemplateDao) {
		this.hibernateTemplateDao = hibernateTemplateDao;
	}
	
}
