package com.es.plailing.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
@Service
public interface CommentService {
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(���ݿγ�Ŀ¼id��ҳ��ѯ����)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return    ����
	    * @return Page<Comment>    ��������
	    * @throws
	 */
	public Page<Comment> Find(int pageNum, int pageSize, int catalogId);
	/**
	 * 
	    * @Title: Save
	    * @Description: TODO(���ݿ��������)
	    * @param @param entity    ����
	    * @return void    ��������
	    * @throws
	 */
	public void Save(Comment entity);
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(��������id��������)
	    * @param @param id
	    * @param @return    ����
	    * @return Comment    ��������
	    * @throws
	 */
	public Comment Get(Integer id);
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(���ݸ����۲���������)
	    * @param @param top
	    * @param @return    ����
	    * @return List<Comment>    ��������
	    * @throws
	 */
	public List<Comment> FindSon(int top);
	/**
	 * 
	    * @Title: FindOne
	    * @Description: TODO(�����������ݲ�������)
	    * @param @param text
	    * @param @return    ����
	    * @return Comment    ��������
	    * @throws
	 */
	public Comment FindOne(String text);
	/**
	 * 
	    * @Title: FindUser
	    * @Description: TODO(�����û�email�����û�)
	    * @param @param email
	    * @param @return    ����
	    * @return User    ��������
	    * @throws
	 */
	public User FindUser(String email);
	/**
	 * 
	    * @Title: getSingleCourse
	    * @Description: TODO(���ݿγ�Ŀ¼id��ѯ�γ�)
	    * @param @param catalogId
	    * @param @return    ����
	    * @return CourseCatalog    ��������
	    * @throws
	 */
	public CourseCatalog getSingleCourse(int catalogId);
	/**
	 * 
	    * @Title: getTeacher
	    * @Description: TODO(���ݿγ�Ŀ¼id��ѯ�ϴ��û�)
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return User    ��������
	    * @throws
	 */
	public User getTeacher(int catalogId);
	/**
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
	public List<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId);
	/**
	 * 
	    * @Title: listComment
	    * @Description: TODO(����ҳ����������)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Comment>    ��������
	    * @throws
	 */
	public List<Comment> listComment(int pageNum,int pageSize,int catalogId);
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
	public List<CourseCatalog> listCourseCatalogByPid(int pid);
}
