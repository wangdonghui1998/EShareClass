package com.es.plailing.checkinform.service;

import java.util.List;

import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;

/**
 * 
    * @ClassName: CourseReleaseService
    * @Description: TODO(������һ�仰��������������)
    * @author ������
    * @date 2018��12��18��
    *
 */
public interface CheckInformService {

	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(����id��ѯ�ϴ��γ�֪ͨ)
	    * @param @param userId
	    * @param @return    ����
	    * @return List<Inform>    ��������
	    * @throws
	 */
	public List<Inform> findInform(int userId);
	
	/**
	 * 
	    * @Title: pageInform
	    * @Description: TODO(����id��ҳ��ѯ�ϴ��γ�֪ͨ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    ����
	    * @return Page<Inform>    ��������
	    * @throws
	 */
	public Page<Inform> pageInform(int pageNum,int pageSize,int userId);
}
