package com.es.plailing.courselist.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;


@Repository
/**
 * 
    * @ClassName: CourseListDaoImpl
    * @Description: TODO(courselistҳ�����CourseType��dao)
    * @author ������
    * @date 2018��12��8��
    *
 */
public class CourseListDaoImpl extends BaseDao<CourseType,Integer>{
	/**
	 * 
	    * @Title: findAllCourseParentType
	    * @Description: TODO(��ѯ���пγ̵ĸ�����)
	    * @param @return 
	    * @param @throws Exception    ����
	    * @return List<CourseType>    
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<CourseType> listAllCourseParentType() throws Exception{
		String hql = "from CourseType ct where ct.courseType=null";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * 
	    * @Title: getParentType
	    * @Description: TODO(ͨ���γ�����Id��ѯ�γ�����)
	    * @param @param tId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return CourseType   
	    * @throws
	 */
	public CourseType getParentType(int tId) throws Exception {
		String hql = "from CourseType ct where ct.typeId=?";
		Object[] params = {tId};
		return this.findOne(hql, params);
	}
	@SuppressWarnings("unchecked")
	public List<CourseType> listCourseChildType(int fId) throws Exception{
		String hql = "from CourseType ct where ct.courseType.typeId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0,fId);
		return query.list();
	}
}
