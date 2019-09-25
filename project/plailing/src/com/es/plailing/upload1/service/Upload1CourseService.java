package com.es.plailing.upload1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.CourseType;
@Service
/**
 * 
    * @ClassName: Upload1CourseService
    * @Description: TODO(���ϴ��γ��йصõ�����)
    * @author �����
    * @date 2018��12��03��
    *
 */
public interface Upload1CourseService {
	/**
	 * 
	    * @Title: Save
	    * @Description: TODO(�γ̴������ݿ�)
	    * @param @param entity    ����
	    * @return void    ��������
	    * @throws
	 */
	public void Save(Course entity);
	@Transactional(readOnly=false)
	/**
	 * 
	    * @Title: SaveCatalog
	    * @Description: TODO(�γ�Ŀ¼�������ݿ�)
	    * @param @param courseCatalog    ����
	    * @return void    ��������
	    * @throws
	 */
	public void SaveCatalog(CourseCatalog courseCatalog);
	/**
	 * 
	    * @Title: FindAll
	    * @Description: TODO(�������пγ�����)
	    * @param @return    ����
	    * @return List<CourseType>    ��������
	    * @throws
	 */
	public List<CourseType>FindAll();
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(���ݿγ̸�����id���ҿγ����͵�typeId,typeName)
	    * @param @param objects
	    * @param @return    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<Object[]> Find(Object[]objects);
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(����id���ҿγ�����)
	    * @param @param typeId
	    * @param @return    ����
	    * @return CourseType    ��������
	    * @throws
	 */
	public CourseType Get(Integer typeId);
	/**
	 * 
	    * @Title: FindOne
	    * @Description: TODO(���ݿγ̸�Ŀ¼id��ѯ�γ�Ŀ¼)
	    * @param @param objects
	    * @param @return    ����
	    * @return CourseCatalog    ��������
	    * @throws
	 */
	public CourseCatalog FindOne(Object[]objects);
	/**
	 * 
	    * @Title: GetCourse
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param courseId
	    * @param @return    ����
	    * @return Course    ��������
	    * @throws
	 */
	public Course GetCourse(Integer courseId);
	/**
	 * 
	    * @Title: findCatalog
	    * @Description: TODO(����Ŀ¼catalogName��ѯĿ¼)
	    * @param @param catalogName
	    * @param @return    ����
	    * @return Course    ��������
	    * @throws
	 */
	public CourseCatalog findCatalog(String catalogName,int courseId);

}
