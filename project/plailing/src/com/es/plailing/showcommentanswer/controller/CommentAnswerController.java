package com.es.plailing.showcommentanswer.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.coursecomment.service.CourseCommenServiceImpl;
import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.showcommentanswer.service.CommentAnswerService;
import com.es.plailing.upload.service.UploadServiceImpl;

@Controller
public class CommentAnswerController {

	@Resource
	private CommentAnswerService commentAnswerServiceImpl;
	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	@Resource
	private CourseCommenServiceImpl courseCommentServiceImpl;

	@RequestMapping("/commentAnswer")
	public String getCommentAnswer(HttpServletRequest request, @RequestParam("commentId") int commentId,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam("courseId") int courseId,
			HttpSession session) {

		String semail = "";
		Object email=session.getAttribute("email");
		//�ж��ղش����������ʲô��״
		if(email!=null) {
		    semail=(String) session.getAttribute("email");
		    int uid=uploadServiceImpl.getUserIdByEmail(semail);
			//�ж�����γ��Ƿ��û��ղ�
			boolean isCollection=courseDetailServiceImpl.isCollection(uid, courseId);
			if(isCollection) {
				request.getServletContext().setAttribute("isCollection", "ok");
			}else {
				request.getServletContext().setAttribute("isCollection", "fail");
			}
		}else {
			request.getServletContext().setAttribute("isCollection", "fail");
		}		
		// �õ��γ̵������Ϣ
		Course c = courseDetailServiceImpl.getCourse(courseId);
		request.getServletContext().setAttribute("course", c);

		// �õ�ѧϰ�˿γ̵�����
		int studyPeople = courseDetailServiceImpl.getStudyCoursePeople(courseId);
		request.getServletContext().setAttribute("studypeople", studyPeople);
		// ͨ���γ̺��ҵ��ϴ��γ̵���
		int cu = courseDetailServiceImpl.getCourseUserId(courseId);

		// ͨ��userid�ҵ���Ӧ����
		User uploadCourseUser = courseDetailServiceImpl.getCourseUser(cu);
		request.getServletContext().setAttribute("uploadCourseUser", uploadCourseUser);

		// ͨ��userid�ҵ��ϴ��γ̵�����
		int uploadCourseCount = courseDetailServiceImpl.getUserUploadCourse(cu);
		request.getServletContext().setAttribute("uploadCourseCount", uploadCourseCount);

		// ͨ�����۵�id�ҵ���Ӧ������
		CourseComment comment = commentAnswerServiceImpl.getComment(commentId);
		request.getServletContext().setAttribute("comment", comment);

		// ͨ�����۵�id�ҵ��ظ������۲��ҷ�ҳ��ʾ
		Page<CourseComment> pageCommentList = commentAnswerServiceImpl.listComment(pageNum, 4, commentId);
		request.getServletContext().setAttribute("pageCommentList", pageCommentList);
		request.getServletContext().setAttribute("commentList", pageCommentList.getList());

		// �õ���˿γ�������ͬ�������γ�
		List<Course> listCourse = courseDetailServiceImpl.listCourse(courseId);
		Map<Course, Integer> mpc = new LinkedHashMap<Course, Integer>();
		for (Course temp : listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);

		request.getServletContext().setAttribute("btn", "btn");
		request.getServletContext().setAttribute("commentId", commentId);
		request.getServletContext().setAttribute("courseId", courseId);
		return "showcommentanswer";
	}

}
