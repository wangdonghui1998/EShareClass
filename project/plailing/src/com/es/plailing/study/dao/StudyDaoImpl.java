package com.es.plailing.study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

/*
 * 
    * @ClassName: StudyDaoImpl
    * @Description: ����study.jsp�����ݿ����Ӳ�ѯ
    * @author ��˼��
    * @date 2018��12��3��
    *
 */
@Repository
public class StudyDaoImpl extends BaseDao<UserJoinCourse,String>{

	/**
	 * 
	    * @Title: findUser
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public List<UserJoinCourse> findCourses(User user) throws Exception {
		String hql="from UserJoinCourse UJC where UJC.user=?";
		Object[] params= {user};
		return super.find(hql, params);
	}
	
	/**
	 * 
	    * @Title: joinCourseByPage
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Page<UserJoinCourse>    ��������
	    * @throws
	 */
	public Page<UserJoinCourse> joinCourseByPage(int pageNum, int pageSize,String email) throws Exception {
		String hqlCount = "select count(*) from UserJoinCourse UB where UB.user.email=?";
		String hql = "from UserJoinCourse UB where UB.user.email=?";//��ʱ�䵹���ѯ
		Object [] params = {email};
		Page<UserJoinCourse> joinCoursePageList = super.findPage(pageNum, pageSize, hqlCount,hql, params);
		return joinCoursePageList;
	}

	
	
}
