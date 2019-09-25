package com.es.plailing.left.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class LeftDaoImpl extends BaseDao<User, Integer> {
	
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(��������ѯ�û�)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */

	public User findLeft(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return this.findOne(hql, params);
	}

}
