package com.template.dao;

import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;

import com.constant.Constant;
import com.template.bean.StatementTemplate;
import com.template.service.DynamicHibernateStatementBuilder;
import com.util.EmptyUtil;
import com.util.HibernateUtil;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Description:   模板查询
 * @author: 杨聪艺
 * Create Date: 2014-8-19
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-19.1		杨聪艺		2014-8-19		create					
 * </pre>
 */
public class HibernateTemplateDao implements InitializingBean {  
    
    protected Map<String, StatementTemplate> templateCache;  
    protected DynamicHibernateStatementBuilder dynamicStatementBuilder;  
      
    public HibernateTemplateDao() {  
        
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
	
	@SuppressWarnings("rawtypes")
	public List queryBySQL(String sql) {
		return null;
	}
	
	public void updateBySQL(String sql) {
		
	}
	
	public void deleteBySQL(String hql) {
		
	}
  
    /**
     * Description :查询在xxx.hbm.xml中配置的查询语句 
     * @param queryName
     * @param parameters
     * @return
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    @SuppressWarnings("rawtypes")
	public List findByNamedQuery(final String queryName, final Map<String, ?> parameters) {
    	//获取模板
        StatementTemplate statementTemplate = templateCache.get(queryName);
        //解析模板
        String statement = processTemplate(statementTemplate,parameters);
        //判断语句类型
        if(statementTemplate.getType() == Constant.STRING.HQL){  
            return queryByHQL(statement);  
        }else{  
            return queryBySQL(statement);  
        }  
    }  
    
    /**
     * Description :spring在初始化bean之后的回调函数
     * @param statementTemplate
     * @param parameters
     * @return
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    @Override  
    public void afterPropertiesSet() throws Exception {
    	//初始化模板查询
        dynamicStatementBuilder.init();
        //获取sql hql
        Map<String,String> namedHQLQueries = dynamicStatementBuilder.getNamedHQLQueries();
        Map<String,String> namedSQLQueries = dynamicStatementBuilder.getNamedSQLQueries();
        
        Configuration configuration = new Configuration();  
        configuration.setNumberFormat("#");  
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        //循环进行缓存
        for(Entry<String, String> entry : namedHQLQueries.entrySet()){  
            stringLoader.putTemplate(entry.getKey(), entry.getValue());  
            templateCache.put(entry.getKey(), new StatementTemplate(Constant.STRING.HQL,new Template(entry.getKey(),new StringReader(entry.getValue()),configuration)));  
        }  
        for(Entry<String, String> entry : namedSQLQueries.entrySet()){  
            stringLoader.putTemplate(entry.getKey(), entry.getValue());  
            templateCache.put(entry.getKey(), new StatementTemplate(Constant.STRING.SQL,new Template(entry.getKey(),new StringReader(entry.getValue()),configuration)));  
        }
        
        configuration.setTemplateLoader(stringLoader);  
    }  
    
    /**
     * Description :
     * @param statementTemplate
     * @param parameters
     * @return
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    protected String processTemplate(StatementTemplate statementTemplate,Map<String, ?> parameters){  
        StringWriter stringWriter = new StringWriter();  
        try {  
            statementTemplate.getTemplate().process(parameters, stringWriter);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return stringWriter.toString();  
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

	public Map<String, StatementTemplate> getTemplateCache() {
		return templateCache;
	}
	public void setTemplateCache(Map<String, StatementTemplate> templateCache) {
		this.templateCache = templateCache;
	}

	public DynamicHibernateStatementBuilder getDynamicStatementBuilder() {
		return dynamicStatementBuilder;
	}
	public void setDynamicStatementBuilder(
			DynamicHibernateStatementBuilder dynamicStatementBuilder) {
		this.dynamicStatementBuilder = dynamicStatementBuilder;
	}  
    
}  
