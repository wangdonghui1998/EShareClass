package com.es.plailing.forgetpwd.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: ForgetPwdDaoImpl
    * @Description: TODO(forgetpwdҳ������û���dao)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Repository
public class ForgetPwdDaoImpl extends BaseDao<User,Integer>{
/**
 * 
    * @Title: updateUserPwd
    * @Description: TODO(�����ݿ����޸��û�������)
    * @param @param email
    * @param @param pwd
    * @param @throws Exception    ����
    * @return void    ��������
    * @throws
 */
	public void updateUserPwd(String email,String pwd) throws Exception {
		Session session = this.sessionFactory.openSession();;
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email",email);
		User u = (User)query.uniqueResult();
		u.setPassword(pwd);
		tx.commit();
		session.close();
	}
	/**
	 * 
	    * @Title: getUser
	    * @Description: TODO(ͨ���û�email����û�)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getUser(String email) throws Exception{
		String hql = "from User u where u.email=?";
		Object[] params = {email};
		return this.findOne(hql, params);
	}
}
