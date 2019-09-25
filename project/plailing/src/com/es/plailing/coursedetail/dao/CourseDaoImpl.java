package com.es.plailing.coursedetail.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CourseDetailDaoImpl
    * @Description: �����ݿ��в�������Ҫ������
    * @author liushanshan
    * @date 2018��11��28��
    *
 */
@Repository
public class CourseDaoImpl extends BaseDao<Course,Integer>{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UsersDaoImpl userDaoImpl;
	/**
	 * 
	    * @Title: updateCourse
	    * @Description: TODO(�޸Ŀγ���Ϣ)
	    * @param @param course
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void updateCourse(Course course) throws Exception {
		update(course);
	}

	/**
	    * @Title: getCourse
	    * @Description: TODO(ͨ���γ̵�Id�õ�course)
	    * @param @param courseId �γ̱��id
	    * @param @return 
	    * @param @throws Exception    ����
	    * @return Course    ��������
	    * @throws
	 */
	public Course getCourse(int courseId) throws Exception{	
		return get(courseId);
	}
	
	/**
	 * 
	    * @Title: getStudyCoursePeople
	    * @Description: TODO(�õ�����ڿε�����)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getStudyCoursePeople(int courseId) throws Exception {
		return get(courseId).getJoinUsers().size();
	}
	/**
	 * 
	    * @Title: getCourseUserId
	    * @Description: TODO(�ҵ��ϴ��γ̵��Ǹ��û���id)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getCourseUserId(int courseId) throws Exception {
		return get(courseId).getUser().getUserId();
	}
	

	/**
	 * 
	    * @Title: listCourse
	    * @Description: TODO(��ȡͬ�����͵������γ�)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Course>    ��������
	    * @throws
	 */
	public List<Course> listCourse(int courseId) throws Exception{
		int typeId =get(courseId).getCourseType().getTypeId();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Course c where c.courseType.typeId=? and c.courseId !=?");
		q.setParameter(0, typeId);
		q.setParameter(1, courseId);
		q.setFirstResult(0);
		q.setMaxResults(3);
		return q.list();
	}
	
	
	
	/**
	 * 
	    * @Title: save
	    * @Description: TODO(�ϴ��γ�)
	    * @param @param entity
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void save(Course entity) throws Exception {
		
		super.save(entity);
	}
}
