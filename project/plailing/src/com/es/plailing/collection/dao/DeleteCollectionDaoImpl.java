package com.es.plailing.collection.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: DeleteCollectionDaoImpl
    * @Description: TODO(�������ݿ�)
    * @author ������
    * @date 2018��12��22��
    *
 */
@Repository
public class DeleteCollectionDaoImpl extends BaseDao<UserCollectionCourse, Integer>{

	/**
	 * 
	    * @Title: checkCourse
	    * @Description: TODO(�����û�ID�Ϳγ�ID��ѯ�˶�)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean checkCourse(int userId,int courseId) throws Exception {
		String hql="from UserCollectionCourse uc where uc.course.courseId=? and uc.user.userId=?";
		Object[] params= {courseId,userId};
		UserCollectionCourse ucc=this.findOne(hql, params);
		if(ucc != null && ucc.getState()==1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	    * @Title: deleteCourse
	    * @Description: TODO(�����û�ID�Ϳγ�ID��������״̬)
	    * @param @param userId
	    * @param @param courseId
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void deleteCourse(int userId,int courseId) throws Exception{
		String hql="from UserCollectionCourse uc where uc.course.courseId=? and uc.user.userId=?";
		Object[] params= {courseId,userId};
		UserCollectionCourse ucc=this.findOne(hql, params);
		ucc.setState(0);
		update(ucc);
	}
}
