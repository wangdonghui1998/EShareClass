package com.es.plailing.upload1.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseDaoImpl extends BaseDao<Course, Integer> {
	/**
	 * 
	    * @Title: get
	    * @Description: TODO(���ݿγ�id��ѯ�γ�)
	    * @param @param courseId
	    * @param @throws Exception    ����
	    * @return Course    ��������
	    * @throws
	 */
	public Course Get(Integer courseId) throws Exception {
		
		return super.get(courseId);
	}
}
