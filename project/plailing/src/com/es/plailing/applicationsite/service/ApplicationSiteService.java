package com.es.plailing.applicationsite.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.ApplicationSite;
import com.es.plailing.entity.Course;
@Service
public interface ApplicationSiteService {
	/**
	 * 
	    * @Title: insertApplicationSiteDaoImpl
	    * @Description: TODO(���û����볡�ص���Ϣ����ݿ���)
	    * @param @param applicationSite    ����
	    * @return void    ��������
	    * @throws
	 */
	public int insertApplicationSiteDaoImpl(String useTime,String siteType,double userLang,Course course);
}
