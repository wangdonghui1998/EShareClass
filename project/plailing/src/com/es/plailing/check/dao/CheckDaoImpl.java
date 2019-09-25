
    /**  
    * @Title: CheckDaoImpl.java
    * @Package com.es.plailing.check.dao
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author ����ϼ
    * @date 2018��12��19��
    * @version V1.0  
    */
    
package com.es.plailing.check.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Auditing;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CheckDaoImpl
    * @Description: TODO(������һ�仰��������������)
    * @author ����ϼ
    * @date 2018��12��19��
    *
    */
@Repository
public class CheckDaoImpl extends BaseDao<Auditing, Integer>{
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertAuditing
	    * @Description: TODO(��Auditing���в�������)
	    * @param @param personalInfo
	    * @param @param identityPic
	    * @param @param teachVideo
	    * @param @param certificate
	    * @param @param state    ����
	    * @return void    ��������
	    * @throws
	 */
	public void insertAuditing(User user,String personalInfo,String identityPic,
			String teachVideo,String certificate,int state) throws Exception {
		Auditing auditing = new Auditing();
		auditing.setUser(user);
		auditing.setPersonalInfo(personalInfo);
		auditing.setIdentityPic(identityPic);
		auditing.setTeachVideo(teachVideo);
		auditing.setCertificate(certificate);
		auditing.setCheckState(state);
		auditing.setAuditingId(0);
		save(auditing);
	}
}
