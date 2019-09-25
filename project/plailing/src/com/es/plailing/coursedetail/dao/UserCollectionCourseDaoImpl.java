package com.es.plailing.coursedetail.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.util.BaseDao;

@Repository
public class UserCollectionCourseDaoImpl extends BaseDao<UserCollectionCourse,Integer>{
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
	public UserCollectionCourse getUserCollectionCourse(int userId,int courseId) throws Exception {
		String hql="from UserCollectionCourse uc where uc.user.userId=? and uc.course.courseId=? and uc.state=?";
		Object[] params= {userId,courseId,1};
		return findOne(hql,params);
	}
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
	public void insertCollection(Course course,User user) throws Exception {
		String hql="from UserCollectionCourse uc where uc.user.userId=? and uc.course.courseId=?";
		Object[] params= {user.getUserId(),course.getCourseId()};
		UserCollectionCourse uc=findOne(hql,params);
		if(uc!=null) {
			uc.setState(1);
			update(uc);
		}else {
			UserCollectionCourse ucc=new UserCollectionCourse();
			ucc.setCourse(course);
			ucc.setDate(new Date());
			ucc.setUser(user);
			ucc.setState(1);
			course.getCollectUsers().add(ucc);
			user.getCollectCourses().add(ucc);
			save(ucc);
		}
	}
	/**
	 * 
	    * @Title: updateCollection
	    * @Description: TODO(ȡ���ղ�)
	    * @param @param ucc
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void updateCollection(int courseId,int userId) throws Exception {
		UserCollectionCourse ucc=getUserCollectionCourse(userId,courseId);
		ucc.setState(0);
		update(ucc);
	}

	
}
