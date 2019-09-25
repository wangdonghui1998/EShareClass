package com.es.plailing.coursecomment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Grade;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
public interface CourseCommentService {
	
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
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,int courseId);
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
	public List<CourseComment> getCourseCommentLast();
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
	/**
	 * 
	    * @Title: giveGrade
	    * @Description: TODO(�û����ֲ������ݿ�����)
	    * @param @param u
	    * @param @param c
	    * @param @param grade    ����
	    * @return void    ��������
	    * @throws
	 */
	public void giveGrade(User u,Course c,int grade);
	/**
	 * 
	    * @Title: getCourseById
	    * @Description: TODO(ͨ���γ�id��ÿγ�)
	    * @param @param courseId
	    * @param @return    ����
	    * @return Course    ��������
	    * @throws
	 */
	public Course getCourseById(int courseId);
	/**
	 * 
	    * @Title: checkGrade
	    * @Description: TODO(����Ƿ�����)
	    * @param @param u
	    * @param @param c
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public boolean checkGrade(User u,Course c);
	/**
	 * 
	    * @Title: findTheGrade
	    * @Description: TODO(���ݿγ̺��û���ѯ����)
	    * @param @param u
	    * @param @param c
	    * @param @return    ����
	    * @return Grade    ��������
	    * @throws
	 */
	public Grade findTheGrade(User u,Course c);
	/**
	 * 
	    * @Title: listGrounds
	    * @Description: TODO(���ݿγ̲�ѯ�˿γ̵ķ�������)
	    * @param @param courseId
	    * @param @return    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<Grade> listGrounds(int courseId);
	/**
	 * 
	    * @Title: updateGrade
	    * @Description: TODO(���¿γ������ֶ�)
	    * @param @param avgGrade
	    * @param @param courseId    ����
	    * @return void    ��������
	    * @throws
	 */
	public void updateGrade(double avgGrade,int courseId);
}
