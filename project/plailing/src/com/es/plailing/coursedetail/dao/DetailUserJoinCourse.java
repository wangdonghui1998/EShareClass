package com.es.plailing.coursedetail.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

@Repository
public class DetailUserJoinCourse extends BaseDao<UserJoinCourse,Integer>{
	
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
	public boolean isJoin(int userId,int courseId) throws Exception {
		String hql="from UserJoinCourse ujc where ujc.user.userId=? and ujc.course.courseId=?";
		Object[] params= {userId,courseId};
		UserJoinCourse ujc=findOne(hql,params);
		if(ujc!=null) {
			return true;
		}else {
			return false;
		}
	}
	
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
	public void insertJoin(User u,Course c) throws Exception {
		UserJoinCourse ujc=new UserJoinCourse();
		ujc.setCourse(c);
		ujc.setJoinTime(new Date());
		ujc.setUser(u);
		c.getJoinUsers().add(ujc);
		u.getJoinCourses().add(ujc);
		save(ujc);
	}
}
