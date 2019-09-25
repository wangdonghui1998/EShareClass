package com.es.plailing.relatecourseinform.service;

import java.util.List;


import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.UserJoinCourse;

/**
 * 
    * @ClassName: RelateService
    * @Description: TODO(��ѯ�ӿ�)
    * @author ������
    * @date 2018��12��3��
    *
 */
public interface CourseInformService {
	
	/**
	 * 
	    * @Title: find
	    * @Description: TODO(�����û�Id��ѯ��������пγ�)
	    * @param @param userId
	    * @param @return    ����
	    * @return User    ��������
	    * @throws
	 */
	public List<UserJoinCourse> find(int userId);
	
	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(���ݿγ̺Ż�ȡ֪ͨ)
	    * @param @param courseId
	    * @param @return    ����
	    * @return List<Inform>    ��������
	    * @throws
	 */
	public List<Inform> findInform(int courseId);
	
	/**
	 * 
	    * @Title: findPage
	    * @Description: TODO(�����û�id��ҳ��ѯ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    ����
	    * @return Page<Inform>    ��������
	    * @throws
	 */
	public Page<Inform> findPage(int pageNum, int pageSize, int userId);
}
