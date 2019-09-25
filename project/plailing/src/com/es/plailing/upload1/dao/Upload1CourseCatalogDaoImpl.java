package com.es.plailing.upload1.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseCatalogDaoImpl extends BaseDao<CourseCatalog, Integer> {
	@Override
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(�γ�Ŀ¼�������ݿ�)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void save(CourseCatalog entity) throws Exception {
		
		super.save(entity);
	}
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(���ݿγ̸�Ŀ¼id��ѯ�γ�Ŀ¼)
	    * @param @param objects
	    * @param @return
	    * @param @throws Exception    ����
	    * @return CourseCatalog    ��������
	    * @throws
	 */
	public CourseCatalog findOne(Object[]objects) throws Exception {
		System.out.println("dao:"+super.findOne(" from CourseCatalog t where t.catalogId=?",objects));
		return super.findOne(" from CourseCatalog t where t.catalogId=?",objects);
	}
	/**
	 * 
	    * @Title: findCatalog
	    * @Description: TODO(����Ŀ¼catalogName��ѯĿ¼)
	    * @param @param catalogName
	    * @param @return
	    * @param @throws Exception    ����
	    * @return CourseCatalog    ��������
	    * @throws
	 */
	public CourseCatalog findCatalog(String catalogName,int courseId) throws Exception {
		Object[] name= {catalogName,courseId};
		return super.findOne(" from CourseCatalog t where t.catalogName=? and t.course.courseId=?", name);
	}
}
