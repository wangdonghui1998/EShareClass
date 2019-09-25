package com.es.plailing.relatecomment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
public interface RelateCourseCommentService {
	/**
	 * 
	    * @Title: getCourseComment
	    * @Description: TODO(ͨ��courseCommentId���ҵ���Ӧ��courseComment����)
	    * @param @param courseCommentId
	    * @param @return    ����
	    * @return CourseComment    ��������
	    * @throws
	 */
	public CourseComment getCourseComment(int courseCommentId);
	/**
	 * 
	    * @Title: listCourseComment
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return    ����
	    * @return Page<Comment>    ��������
	    * @throws
	 */
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,String email);
	/**
	 * 
	    * @Title: insertCourseComment
	    * @Description: TODO(���û��Ĵ����۲��뵽���ݿ���)
	    * @param @param courseComment
	    * @param @param c
	    * @param @param u    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean insertCourseComment(CourseComment courseComment,Course c,User u);
	/**
	 * 
	    * @Title: insertCourseCommentAnswer
	    * @Description: TODO(��ӻظ�������)
	    * @param @param courseComment  ������
	    * @param @param newCourseComment ������
	    * @param @param c  �γ�
	    * @param @param u  �û�
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean insertCourseCommentAnswer(CourseComment courseComment,CourseComment newCourseComment,Course c,User u);
	/**
	 * 
	    * @Title: getCourseCommentLast
	    * @Description: TODO�õ�courseComment���������)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<Object[]> getCourseCommentLast();
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(����������)
	    * @param @param top
	    * @param @return    ����
	    * @return List<CourseComment>    ��������
	    * @throws
	 */
	public List<CourseComment> FindSon(int top);
}
