package com.es.plailing.index.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: IndexDaoImpl
    * @Description: TODO(indexҳ����ڿγ̵�dao)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Repository
public class IndexDaoImpl extends BaseDao<Course,Integer>{
	/**
	 * 
	    * @Title: listCourseByGrades
	    * @Description: TODO(���۸��ѯ12�ڿγ�)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Course>  List<Course>
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseByGrades() throws Exception{
		String hql="from Course as c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc) order by c.grade desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(8);
		List<Course> list = query.list();
		return list;
	}
	/**
	 * 
	    * @Title: listHotCourse
	    * @Description: TODO(�����ֲ�ѯ4�ڿγ�)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Course>    List<Course>
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listHotCourse() throws Exception{
		String hql="from Course as c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc) order by c.courseId desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(4);
		List<Course> list = query.list();
		return list;
	}
}
