package com.es.plailing.coursecomment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CommentDaoImpl
    * @Description: TODO(��ѯ�γ̵��й�����)
    * @author liushanshan
    * @date 2018��11��30��
    *
 */
@Repository
public class CommentCourseCommentDaoImpl extends BaseDao<CourseComment,Integer>{
	

	/**
	 * 
	    * @Title: getCourseComment
	    * @Description: TODO(ͨ��courseCommentId���ҵ���Ӧ��courseComment����)
	    * @param @param courseCommentId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return CourseComment    ��������
	    * @throws
	 */
	public CourseComment getCourseComment(int courseCommentId) throws Exception {
		return get(courseCommentId);
	}
	/**
	 * 
	    * @Title: listCourseComment
	    * @Description: TODO(�õ�����γ̵����۷�ҳ��ʾ)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Page<Comment>    ��������
	    * @throws
	 */
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,int courseId) throws Exception{
		String hqlList="from CourseComment cc where cc.courseComment.courseCommentId is null and cc.course.courseId=? order by cc.courseCommentId desc";
		String hqlCount="select count(*) from CourseComment cc where cc.courseComment.courseCommentId is null and cc.course.courseId=? order by cc.courseCommentId desc";
		Object[] params= {courseId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
		
	}
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertCourseComment
	    * @Description: TODO(���û��Ĵ����۲��뵽���ݿ���)
	    * @param @param courseComment
	    * @param @param c
	    * @param @param u    ����
	    * @return void    ��������
	    * @throws
	 */
	public void insertCourseComment(CourseComment courseComment,Course c,User u) throws Exception {
		courseComment.setCourse(c);
		courseComment.setUser(u);
		courseComment.setCourseComment(null);
		c.getCourseComments().add(courseComment);
		u.getCourseComments().add(courseComment);
		save(courseComment);
	}
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertCourseCommentAnswer
	    * @Description: TODO(��ӻظ�������)
	    * @param @param courseComment
	    * @param @param newCourseComment
	    * @param @param c
	    * @param @param u
	    * @param @return    ����
	    * @return boolean    ��������
	    * @throws
	 */
	public void insertCourseCommentAnswer(CourseComment courseComment,CourseComment newCourseComment,Course c,User u) throws Exception {
		newCourseComment.setCourse(c);
		newCourseComment.setUser(u);
		newCourseComment.setCourseComment(courseComment);
		c.getCourseComments().add(newCourseComment);
		u.getCourseComments().add(newCourseComment);
		courseComment.getCourseComments().add(newCourseComment);
		save(newCourseComment);
	}
	/**
	 * 
	    * @Title: getCourseCommentLast
	    * @Description: TODO�õ�courseComment���������)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<CourseComment> getCourseCommentLast() throws Exception{
		String hql="from CourseComment cc order by cc.courseCommentId desc";
		Object[] params= {};
		return find(0, 1, hql, params);
	}
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(����������)
	    * @param @param top
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<CourseComment>    ��������
	    * @throws
	 */
	public List<CourseComment> FindSon(int top) throws Exception {
		Object[] params= {top};
		return super.find("from CourseComment where top=?",params);
	}
	
	
}
