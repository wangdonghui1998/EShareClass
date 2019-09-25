
    /**  
    * @Title: CourseCatalog.java
    * @Package com.es.plailing.comment.dao
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author Administrator
    * @date 2018��12��24��
    * @version V1.0  
    */
    
package com.es.plailing.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CourseCatalog
    * @Description: TODO(������һ�仰��������������)
    * @author ��ɺɺ
    * @date 2018��12��24��
    *
    */

@Repository
public class CommentCourseCatalogDaoImpl extends BaseDao<CourseCatalog,Integer>{
	/**
	 * @throws Exception 
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(����ҳ����ʾĿ¼)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<CourseCatalog>    ��������
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId) throws Exception{
		String hql="from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		Object[] params= {courseId};
		return find(pageNum, pageSize, hql, params);
	}
	/**
	 * 
	    * @Title: listCourseCatalogByPid
	    * @Description: TODO(ͨ����Ŀ¼�ҵ���Ŀ¼)
	    * @param @param pid
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<CourseCatalog>    ��������
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalogByPid(int pid) throws Exception{
		String hql="from CourseCatalog cc where cc.courseCatalog.catalogId=? order by cc.catalogId desc";
		Object[] params= {pid};
		return find(hql,params);
 	}

}
