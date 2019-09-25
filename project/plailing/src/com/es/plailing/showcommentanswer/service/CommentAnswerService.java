package com.es.plailing.showcommentanswer.service;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;

@Service
public interface CommentAnswerService {
	/**
	 * 
	    * @Title: listComment
	    * @Description: TODO(��ҳ��ʾ������۵Ļظ�)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param commentId
	    * @param @return    ����
	    * @return Page<Comment>    ��������
	    * @throws
	 */
	public Page<CourseComment> listComment(int pageNum,int pageSize,int commentId);
	/**
	 * 
	    * @Title: getComment
	    * @Description: TODO(ͨ��commentId�ҵ�Comment)
	    * @param @param commentId
	    * @param @return    ����
	    * @return Comment    ��������
	    * @throws
	 */
	public CourseComment getComment(int commentId);
}
