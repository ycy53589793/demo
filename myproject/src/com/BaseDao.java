package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

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
	
	public void queryById() {
		
	}
	
	public void queryBySQL(String sql) {
		
	}
	
	public void updateBySQL(String sql) {
		
	}
	
	public void deleteBySQL(String hql) {
		
	}
	
	public void queryByHQL(String hql) {
		
	}
	
	public void deleteByHQL(String hql) {
		
	}
	
	public void updateByHQL(String hql) {
		
	}
	
	public void insertByHQL(String hql) {
		
	}
	
	public void deleteById(Long id,Object obj) {
		
	}
	
	public void deleteByIds(Long ids[],Object obj) {
		
	}
	
	public void deleteByIds(List<Long> ids,Object obj) {
		
	}
	
	@SuppressWarnings("rawtypes")
	public abstract List queryByCondition(Map<String,Object> condition);
	
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
	
	public void save(Object obj) {
		Session s=HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		s.save(obj);
		tx.commit();
		HibernateUtil.closeSession(s);
	}
	
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
	
	public void delete(Object obj) {
		Session s=HibernateUtil.getSession();
		Transaction tx=s.beginTransaction();
		s.delete(obj);
		tx.commit();
		HibernateUtil.closeSession(s);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAll(Class<?> clazz) {
		return queryByPageInfo(clazz,null,null);
	}
	
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
	
	@SuppressWarnings("rawtypes")
	public Iterator searchAll(Class<?> clazz) {
		return searchByPageInfo(clazz,null,null);
	}
	
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
	
	@SuppressWarnings("rawtypes")
	public List findAll(Class<?> clazz) {
		return findByPageInfo(clazz,null,null);
	}
	
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
//	public long getCount(String hsql) {
//		Session session=HibernateUtil.getSession();
//		Query q=session.createQuery(hsql);
//		long count=(Long)q.list().get(0);
//		HibernateUtil.closeSession(session);
//		return count;
//	}
	
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
