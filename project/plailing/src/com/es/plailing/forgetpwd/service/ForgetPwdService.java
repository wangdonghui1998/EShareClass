package com.es.plailing.forgetpwd.service;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: ForgetPwdService
    * @Description: TODO(forgetpwdҳ��service�ӿ���)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Service
public interface ForgetPwdService {
	public  void updateTheUserPwd(String email,String pwd);
	public User getTheUser(String email);
}
