package com;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.util.EmptyUtil;
import com.util.HibernateUtil;

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
	
//	private static final int MAX_RESULT=100;
	
	/**
	 * Description :
	 * @param id
	 * @param clazz
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public Object queryById(Long id,Class<?> clazz) {
		Long ids[] = new Long[1];
		ids[0]=id;
		List res = queryByIds(ids,clazz);
		return res.get(0);
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
	public List queryByIds(Long ids[],Class<?> clazz) {
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
	public List queryByIds(List<Long> ids,Class<?> clazz) {
		String hql = "from "+clazz.getName()+" where id in(";
		for(int i=0;i<ids.size();i++) {
			if(i==0) {
				hql += ids.get(i);
			}
			else {
				hql += ","+ids.get(i);
			}
		}
		return queryByHQL(hql);
	}
	
	/**
	 * Description :
	 * @param hql
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	@SuppressWarnings("rawtypes")
	public List queryByHQL(String hql) {
		Session s = HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		Query q= s.createQuery(hql);
		List res = q.list();
		tx.commit();
		HibernateUtil.closeSession(s);
		return res;
	}
	
	/**
	 * Description :
	 * @param hql
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void deleteByHQL(String hql) {
		updateByHQL(hql);
	}
	
	/**
	 * Description :
	 * @param hql
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public int updateByHQL(String hql) {
		Session s = HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		Query q= s.createQuery(hql);
        int res=q.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession(s);
		return res;
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
	public void deleteByIds(Long ids[],Class<?> clazz) {
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
	public void deleteByIds(List<Long> ids,Class<?> clazz) {
		String hql = "delete from "+clazz.getName()+" where id in(";
		for(int i=0;i<ids.size();i++) {
			if(i==0) {
				hql += ids.get(i);
			}
			else {
				hql += ","+ids.get(i);
			}
		}
		deleteByHQL(hql);
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
	
	/**
	 * Description :查询总记录数
	 * @param hsql
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-6-8
	 */
	public long getCount(String hsql) {
		Session session=HibernateUtil.getSession();
		Query q=session.createQuery(hsql);
		long count=(Long)q.list().get(0);
		HibernateUtil.closeSession(session);
		return count;
	}
	
	public void queryBySQL(String sql) {
		
	}
	
	public void updateBySQL(String sql) {
		
	}
	
	public void deleteBySQL(String hql) {
		
	}
	
	/**
	 * Description :
	 * @param sql
	 * @Author: 杨聪艺
	 * @Create Date: 2014-8-13
	 */
	public void insertBySQL(String sql) {
		Connection con=getConnection();
		PreparedStatement ps=getPreparedStatement(con, sql);
		
		try {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(con);
		}
	}
	
	protected Connection getConnection() {
		
		Connection con=null;
		
		return con;
	}
	
	protected PreparedStatement getPreparedStatement(Connection con,String sql) {
		
		PreparedStatement ps=null;
		
		if(EmptyUtil.isEmpty(con)) {
			return ps;
		}
		
		try {
			ps=con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	protected void closeResultSet(ResultSet rs) {
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			rs=null;
		}
		
	}
	
	protected void closeAll(Connection con,PreparedStatement ps,ResultSet rs) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(con);
	}
	
	protected void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			con=null;
		}
	}
	
	protected void closePreparedStatement(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ps=null;
		}
	}

}
