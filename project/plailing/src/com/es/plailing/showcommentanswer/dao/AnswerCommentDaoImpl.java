package com.es.plailing.showcommentanswer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

@Repository
public class AnswerCommentDaoImpl extends BaseDao<CourseComment,Integer>{
	
	/**
	 * @throws Exception 
	 * 
	    * @Title: listComment
	    * @Description: TODO(�ҵ���id��commentId�����лظ�����)
	    * @param @param commentId
	    * @param @return    ����
	    * @return List<Comment>    ��������
	    * @throws
	 */
	public Page<CourseComment> listComment(int pageNum,int pageSize,int commentId) throws Exception{
		String hqlList="from CourseComment cc where cc.courseComment.courseCommentId=? order by cc.courseCommentId desc";
		String hqlCount="Select count(*) from CourseComment cc where cc.courseComment.courseCommentId=? order by cc.courseCommentId desc";
		Object[] params= {commentId};
		return findPage(pageNum,pageSize,hqlCount,hqlList,params);
	}
	/**
	 * 
	    * @Title: getComment
	    * @Description: TODO(ͨ��commentId�ҵ�Comment)
	    * @param @param commentId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Comment    ��������
	    * @throws
	 */
	public CourseComment getComment(int commentId) throws Exception {
		String hql="from CourseComment c where c.courseCommentId=?";
		Object[] params= {commentId};
		return findOne(hql, params);
	}
}
