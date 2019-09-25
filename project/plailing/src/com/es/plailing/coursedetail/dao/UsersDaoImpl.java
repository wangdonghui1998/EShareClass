package com.es.plailing.coursedetail.dao;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class UsersDaoImpl extends BaseDao<User,Integer>{
	
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(�޸��û���Ϣ)
	    * @param @param u
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void updateUser(User u) throws Exception {
		update(u);
	}
	
	/**
	 * 
	    * @Title: getCourseUser
	    * @Description: TODO(ͨ��userId�ҵ��û�)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getCourseUser(int userId) throws Exception {
		return get(userId);
	}
	
	/**
	 * 
	    * @Title: getUserUploadCourse
	    * @Description: TODO(ͨ��userId�ҵ�����ͻ��ϴ��Ŀγ���)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getUserUploadCourse(int userId) throws Exception {
		return get(userId).getUploadCourses().size();
	}
	/**
	 * 
	    * @Title: getUserByEmail
	    * @Description: TODO(ͨ��email���Ҷ���)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Users    ��������
	    * @throws
	 */
	public User getUserByEmail(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return findOne(hql,params);
	}
	/**
	 * 
	    * @Title: getTeacher
	    * @Description: TODO(ͨ��Ŀ¼id��ѯ�������û�)
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getTeacher(int catalogId) throws Exception{
		String hql = "from User u where u.userId=(select c.user.userId from Course c where c.courseId=(select cc.course.courseId from CourseCatalog cc where cc.catalogId=?))";
		Object[] params = {catalogId};
		return this.findOne(hql, params);
	}

	
}
