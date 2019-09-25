package com.es.plailing.coursedetail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.coursedetail.dao.UserCollectionCourseDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.entity.UserJoinCourse;;

/**
 * 
    * @ClassName: CourseDetailService
    * @Description: TODO(������һ�仰��������������)
    * @author liushanshan
    * @date 2018��11��28��
    *
 */
@Service
public interface CourseDetailService {
	/**
	 * 
	    * @Title: getCourse
	    * @Description: TODO(ͨ���γ�id�ҵ��γ�)
	    * @param @param courseId
	    * @param @return    ����
	    * @return Course    ��������
	    * @throws
	 */
	public Course getCourse(int courseId);
	/**
	 * 
	    * @Title: getStudyCoursePeople
	    * @Description: TODO(ͨ���γ��ҳ�ѧϰ�γ�����)
	    * @param @param courseId
	    * @param @return    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getStudyCoursePeople(int courseId);
	/**
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(ͨ���γ̺��ҵ��γ̵�һ��Ŀ¼,��ҳ��ʾ)
	    * @param @param courseId
	    * @param @return    ����
	    * @return List<CourseCatalog>    ��������
	    * @throws
	 */
	public Page<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId);
	/**
	 * 
	    * @Title: getCourseUser
	    * @Description: TODO(ͨ��userId�õ�User)
	    * @param @param userId
	    * @param @return    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getCourseUser(int userId);
	/**
	 * 
	    * @Title: getUserUploadCourse
	    * @Description: TODO(ͨ��userId�ҵ��ϴ��γ̵�����)
	    * @param @param userId
	    * @param @return    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getUserUploadCourse(int userId);
	/**
	 * 
	    * @Title: getCourseUserId
	    * @Description: TODO(ͨ���γ̺��ҵ��ϴ��γ̵���)
	    * @param @param courseId
	    * @param @return    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getCourseUserId(int courseId);
	/**
	 * 
	    * @Title: getUserByEmail
	    * @Description: TODO(ͨ��email���Ҷ���)
	    * @param @param email
	    * @param @return    ����
	    * @return Users    ��������
	    * @throws
	 */
	public User getUserByEmail(String email);
	/**
	 * 
	    * @Title: listCourse
	    * @Description: TODO(��ȡͬ�����͵������γ�)
	    * @param @param courseId
	    * @param @return    ����
	    * @return List<Course>    ��������
	    * @throws
	 */
	public List<Course> listCourse(int courseId);
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(�޸��û���Ϣ)
	    * @param @param u    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean updateUser(User u);
	/**
	 * 
	    * @Title: insertUserBalance
	    * @Description: TODO(�����Ǯ��ϸ)
	    * @param @param u
	    * @param @param ub
	    * @param @param c
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean insertUserBalance(User u,UserBalance ub,Course c);
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(��������)
	    * @param @param c
	    * @param @param u    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean insert(Course c,User u);
	/**
	 * 
	    * @Title: isCollection
	    * @Description: TODO(�ж�����γ��Ƿ�����û��ղ�)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean isCollection(int userId,int courseId);
	/**
	 * 
	    * @Title: insertCollection
	    * @Description: TODO(���û��Ϳγ̼��뵽�ղر���)
	    * @param @param course
	    * @param @param user
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean insertCollection(Course course,User user);
	/**
	 * 
	    * @Title: updateCollection
	    * @Description: TODO(ȡ���ղ�)
	    * @param @param ucc
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean updateCollection(int courseId,int userId);
	/**
	 * 
	    * @Title: isCollection
	    * @Description: TODO(�ж�����γ��Ƿ�����û�����)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean isJoin(int userId,int courseId);
	/**
	 * 
	    * @Title: insertJoin
	    * @Description: TODO(��ӿγ��ղر�)
	    * @param @param u
	    * @param @param c
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean insertJoin(User u,Course c);
	/**
	 * 
	    * @Title: updateCourse
	    * @Description: TODO(�޸Ŀγ���Ϣ)
	    * @param @param course
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean updateCourse(Course course);
}
