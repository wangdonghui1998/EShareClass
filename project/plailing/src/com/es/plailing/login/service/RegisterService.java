package com.es.plailing.login.service;

import java.util.List;
import java.util.Map;

import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: LoginService
    * @Description: TODO(ע��͵�¼�ӿ�)
    * @author ������
    * @date 2018��12��4��
    *
 */
public interface RegisterService {
	
	/**
	 * 
	    * @Title: insertUser
	    * @Description: TODO(ע���û��ӿ�)
	    * @param @param user    ����
	    * @return void    ��������
	    * @throws
	 */
	public void insertUser(User user);
	
	/**
	 * 
	    * @Title: findAllUser
	    * @Description: TODO(��ѯ�����û��Ľӿ�)
	    * @param @return    ����
	    * @return List<User>    ��������
	    * @throws
	 */
	public List<User> findAllUser();
}
