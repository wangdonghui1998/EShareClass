package com.es.plailing.upload1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseTypeDaoImpl extends BaseDao<CourseType, Integer> {
	@Override
	/**
	 * 
	    * @Title: findAll
	    * @Description: TODO(�������еĿγ�����)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<CourseType>    ��������
	    * @throws
	 */
	public List<CourseType> findAll() throws Exception {
		System.out.println("ssss");
		System.out.println(super.findAll());
		return super.findAll();
	}
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(���ݿγ̸�����id���ҿγ����͵�typeId,typeName)
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
	    * @Title: Get
	    * @Description: TODO(����id���ҿγ�����)
	    * @param @param typeId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return CourseType    ��������
	    * @throws
	 */
	public CourseType Get(Integer typeId) throws Exception{
		return super.get(typeId);
	}
}
