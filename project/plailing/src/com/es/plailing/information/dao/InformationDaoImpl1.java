package com.es.plailing.information.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: InformationDaoImpl1
    * @Description: TODO(informationҳ������û���dao)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Repository
public class InformationDaoImpl1  extends BaseDao<User,Integer>{
	/**
	 * 
	    * @Title: getUser
	    * @Description: TODO(ͨ��userId��ѯUser)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getUser(int userId) throws Exception{
		String hql = "from User u where u.userId=?";
		Object[] params= {userId};
		return this.findOne(hql, params);
	}
	public User getUserByEmail(String email) throws Exception{
		Session session = this.sessionFactory.openSession();;
		String hql = "from User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email",email);
		User u = (User)query.uniqueResult();
		return u;
	}
}
