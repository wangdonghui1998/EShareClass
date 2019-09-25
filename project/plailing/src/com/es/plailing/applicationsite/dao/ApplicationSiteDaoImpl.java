package com.es.plailing.applicationsite.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.ApplicationSite;
import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;

@Repository
public class ApplicationSiteDaoImpl extends BaseDao<ApplicationSite,Integer>{
	/**
	 * 
	    * @Title: insertApplicationSiteDaoImpl
	    * @Description: TODO(�����볡�ص���Ϣ��ӵ����ݿ���)
	    * @param @param applicationSite
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void insertApplicationSiteDaoImpl(Date now,String siteType,double userLang,Course course) throws Exception {
   	 	
   	 	//�õ�application����
		ApplicationSite applicationSite=new ApplicationSite();
   	 	applicationSite.setUseTime(now);
   	    applicationSite.setSiteType(siteType);
   	    applicationSite.setUseLang(userLang);
		applicationSite.setApplicationTime(new Date());
		applicationSite.setCourse(course);
		
		course.getApplicationSites().add(applicationSite);
		
		save(applicationSite);
	}

}
