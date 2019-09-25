package com.es.plailing.forgetpwd.service;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.User;
import com.es.plailing.forgetpwd.dao.ForgetPwdDaoImpl;
/**
 * 
    * @ClassName: ForgetPwdServiceImpl
    * @Description: TODO(forgetpwdҳ��serviceʵ����)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Service
@Transactional(readOnly=false)
public class ForgetPwdServiceImpl implements ForgetPwdService {
	@Resource
	private ForgetPwdDaoImpl forgetPwdDaoImpl;

	@Override
	public void updateTheUserPwd(String email,String pwd) {
		// TODO Auto-generated method stub
		try {
			this.forgetPwdDaoImpl.updateUserPwd(email,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public User getTheUser(String email) {
		// TODO Auto-generated method stub
		try {
			return this.forgetPwdDaoImpl.getUser(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
