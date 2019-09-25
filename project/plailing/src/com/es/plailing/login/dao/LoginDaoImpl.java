package com.es.plailing.login.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: LoginDaoImpl
    * @Description: TODO(�������ݿ⣬��������ɾ�Ĳ�)
    * @author ������
    * @date 2018��12��5��
    *
 */
@Repository
public class LoginDaoImpl extends BaseDao<User, Integer> {
	
	/**
	 * 
	    * @Title: insertUser
	    * @Description: TODO(ע��ʱ�������ݿ�)
	    * @param @param user
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void insertUser(User user) throws Exception {
		this.save(user);
	}
	
	/**
	 * 
	    * @Title: findAllUser
	    * @Description: TODO(���������û�)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<User>    ��������
	    * @throws
	 */
	public List<User> findAllUser() throws Exception{
		return this.findAll();
	}
		
	
}
