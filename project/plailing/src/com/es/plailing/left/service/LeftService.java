package com.es.plailing.left.service;

import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: LeftService
    * @Description: TODO(��ѯ�ӿ�)
    * @author ������
    * @date 2018��12��3��
    *
 */
public interface LeftService {
	
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(��������ѯ�ӿ�)
	    * @param @param email
	    * @param @return    ����
	    * @return User    ��������
	    * @throws
	 */

	public User findLeft(String email);
}
