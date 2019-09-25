package com.es.plailing.relatecomment.service;

import java.util.List;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

public interface RelateCommentService {
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(�����û�email��ҳ��ѯ����)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return    ����
	    * @return Page<Comment>    ��������
	    * @throws
	 */
	public Page<Comment> Find(int pageNum, int pageSize, String email);
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
}
