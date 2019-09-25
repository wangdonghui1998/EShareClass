package com.es.plailing.upload.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;

@Service
public interface UploadService {
	/**
	 * 
	    * @Title: listCourseByUserId
	    * @Description: TODO(ͨ��userId�������ϴ��Ŀγ�����Щ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Page<Course>    ��������
	    * @throws
	 */
	public Page<Course> listCourseByUserId(int pageNum,int pageSize,int userId);
	/**
	 * 
	    * @Title: getUserIdByEmail
	    * @Description: TODO(ͨ��email�ҵ��û���id)
	    * @param @param email
	    * @param @return    ����
	    * @return int    ��������
	    * @throws
	 */
	public int getUserIdByEmail(String email);

}
