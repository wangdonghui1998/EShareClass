package com.es.plailing.relatecourseinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: RelateDaoImpl
    * @Description: TODO(�������ݿ�)
    * @author ������
    * @date 2018��12��3��
    *
 */

@Repository
public class CourseInformDaoImpl extends BaseDao<UserJoinCourse, Integer> {

	/**
	 * 
	    * @Title: find
	    * @Description: TODO(�����û�Id��ѯ��������пγ�)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Course>    ��������
	    * @throws
	 */
	public List<UserJoinCourse> find(int userId) throws Exception{
		String hql="from UserJoinCourse u where u.user.userId=?";
		Object[] params= {userId};
		return find(hql, params);
	}
	
}
