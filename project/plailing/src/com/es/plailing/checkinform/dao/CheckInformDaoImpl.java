package com.es.plailing.checkinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CourseReleaseDaoImpl
    * @Description: TODO(�������ݿ�)
    * @author ������
    * @date 2018��12��18��
    *
 */
@Repository
public class CheckInformDaoImpl extends BaseDao<Inform, Integer>{

	/**
	 * 
	    * @Title: findCourse
	    * @Description: TODO(����Id��ȡ�ϴ��γ̵�֪ͨ)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Course>    ��������
	    * @throws
	 */
	public List<Inform> findInform(int userId) throws Exception{
		String hql="from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)";
		Object[] params= {userId};
		return find(hql, params);
	}
	
	/**
	 * 
	    * @Title: pageInform
	    * @Description: TODO(�����û�Id��ҳ��ѯ�ϴ��γ���Ϣ֪ͨ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Page<Inform>    ��������
	    * @throws
	 */
	public Page<Inform> pageInform(int pageNum,int pageSize,int userId) throws Exception{
		String hqlCount="select count(*) from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)";
		String hqlList="from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)"; 
		Object[] params= {userId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
}
