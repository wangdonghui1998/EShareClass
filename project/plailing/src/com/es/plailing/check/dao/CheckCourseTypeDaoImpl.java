package com.es.plailing.check.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CheckDaoImpl
    * @Description: TODO(Auditing�����ز���)
    * @author ����ϼ
    * @date 2018��12��5��
    *
 */

@Repository
public class CheckCourseTypeDaoImpl extends BaseDao<CourseType, Integer> {
	    /**
	     * @throws Exception 
	    * @Title: courseTypeList
	    * @Description: TODO(�ҵ����е�һ������)
	    * @param @return    ����
	    * @return List<CourseType>    ��������
	    * @throws
	    */
	    
	public List<CourseType> courseTypeList() throws Exception {
		// TODO Auto-generated method stub
		return findAll();
	}
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(ͨ��typeId�ҵ�typeName)
	    * @param @param objects
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<Object[]> Find(Object[]objects) throws Exception {
		return super.findByProjection("select typeId,typeName from CourseType where courseType.typeId=?",objects);
	}
	
	/**
	 * 
	    * @Title: findTypeId
	    * @Description: TODO(ͨ�������������ҵ���Ӧ��TypeId)
	    * @param @param name
	    * @param @return
	    * @param @throws Exception    ����
	    * @return int    ��������
	    * @throws
	 */
	public CourseType findTypeId(int typeId) throws Exception {
		String hql = "from CourseType ct where ct.typeId=?";
		Object[] params = {typeId};
		return findOne(hql, params);
	}
}
