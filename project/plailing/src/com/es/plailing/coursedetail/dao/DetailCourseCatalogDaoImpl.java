package com.es.plailing.coursedetail.dao;


import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

@Repository
public class DetailCourseCatalogDaoImpl extends BaseDao<CourseCatalog,Integer>{

	/**
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(�õ��ÿγ̵�һ��Ŀ¼�Ķ���)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<CourseCatalog>    ��������
	    * @throws
	 */
	public Page<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId) throws Exception{
		String hqlList="from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		String hqlCount="select count(*) from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		Object[] params= {courseId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}

	

}
