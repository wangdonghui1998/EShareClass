package com.es.plailing.collection.service;

import java.util.List;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: CollectionService
    * @Description: TODO(����һ���ӿ�)
    * @author ������
    * @date 2018��12��3��
    *
 */
public interface CollectionService {
	
	/**
	 * 
	 * 
	    * @Title: findOne
	    * @Description: TODO(��������ѯ�û��ӿ�)
	    * @param @param email
	    * @param @return    ����
	    * @return User    ��������
	    * @throws
	 */
	
	public User findOne(String email);
	
	/**
	 * 
	    * @Title: findPage
	    * @Description: TODO(��ҳ��ѯ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return    ����
	    * @return Page<Course>    ��������
	    * @throws
	 */
	public Page<Course> findPage(int pageNum, int pageSize, String email);
	
	/**
	 * 
	    * @Title: findCourse
	    * @Description: TODO(��ѯ�μ����ſε�����)
	    * @param @param email
	    * @param @return    ����
	    * @return List<Course>    ��������
	    * @throws
	 */
	
	public List<Course> findCourse(String email);
	
	/**
	 * 
	    * @Title: checkCourse
	    * @Description: TODO(�˶���Ϣ��ѯ�ӿ�)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	
	public boolean checkCourse(int userId,int courseId);
	
	/**
	 * 
	    * @Title: deleteCourse
	    * @Description: TODO(��������״̬)
	    * @param @param userId
	    * @param @param courseId    ����
	    * @return void    ��������
	    * @throws
	 */
	public void deleteCourse(int userId,int courseId);
}
