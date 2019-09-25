package com.es.plailing.collection.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CollectionDaoImpl
    * @Description: TODO(ʵ�ֺ����ݿ�����)
    * @author ������
    * @date 2018��12��3��
    *
 */

@Repository

public class CollectionDaoImpl extends BaseDao<User, Integer>{
	
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

	public User findOne(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return this.findOne(hql, params);
	}
}
