package com.es.plailing.relatecourseinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Inform;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: InformDaoImpl
    * @Description: TODO(�������ݿ��ȡinform�������)
    * @author ������
    * @date 2018��12��17��
    *
 */
@Repository
public class InformDaoImpl extends BaseDao<Inform, Integer>{

	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(���ݿγ̺Ż�ȡ֪ͨ)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Inform>    ��������
	    * @throws
	 */
	public List<Inform> findInform(int courseId) throws Exception {
		String hql="from Inform i where i.course.courseId=? and state=1";
		Object[] params= {courseId};
		return find(hql, params);
	}
}
