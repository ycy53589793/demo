package com.user.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.BaseDao;
import com.user.bean.User;
import com.util.EmptyUtil;
import com.util.HibernateUtil;

/**
 * Description:   
 * @author: 杨聪艺
 * Create Date: 2014-8-7
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-7.1		杨聪艺		2014-8-7		create					
 * </pre>
 */
public class UserDao extends BaseDao {
	
	/**
	 * Description :根据条件查询user
	 * @param condition
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	@SuppressWarnings("rawtypes")
	public List queryByCondition(Map<String,Object> condition) {
		//获取session
		Session session=HibernateUtil.getSession();
		//构造查询条件
		Criteria criteria=session.createCriteria(User.class);
		if(EmptyUtil.isNotNull(condition)) {
			Set<String> keys=condition.keySet();
			for(String key:keys) {
				criteria.add(Restrictions.eq(key,condition.get(key)));
			}
		}
		//查询
		List res=criteria.list();
		//关闭session
		HibernateUtil.closeSession(session);
		//返回
		return res;
	}

}
