package com.es.plailing.coursecomment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.es.plailing.coursecomment.service.CourseCommentService;
import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Grade;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.information.service.InformationServiceImpl;
import com.es.plailing.upload.service.UploadServiceImpl;

@Controller
public class CourseCommentController {

	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private CourseCommentService courseCommentServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	@Resource
	private InformationServiceImpl informationServiceImpl;

	@RequestMapping("/coursecomment")
	public String getCourseComment(HttpServletRequest request, @RequestParam("courseId") int courseId,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, HttpSession session) {
		String semail = "";
		int uid=0;
		Object email = session.getAttribute("email");
		// �ж��ղش����������ʲô��״
		if (email != null) {
			semail = (String) session.getAttribute("email");
			uid = uploadServiceImpl.getUserIdByEmail(semail);
			// �ж�����γ��Ƿ��û��ղ�
			boolean isCollection = courseDetailServiceImpl.isCollection(uid, courseId);
			if (isCollection) {
				request.getServletContext().setAttribute("isCollection", "ok");
			} else {
				request.getServletContext().setAttribute("isCollection", "fail");
			}

			User loginPerson = this.informationServiceImpl.getTheUserByEmail(semail);
			Course gradeCourse = this.courseCommentServiceImpl.getCourseById(courseId);
			if (this.courseDetailServiceImpl.isJoin(loginPerson.getUserId(), gradeCourse.getCourseId())) {
				request.getServletContext().setAttribute("joinflag", 1);
				if (this.courseCommentServiceImpl.checkGrade(loginPerson, gradeCourse)) {
					double myGrade = this.courseCommentServiceImpl.findTheGrade(loginPerson, gradeCourse).getGrade();
					System.out.print(myGrade);
					request.getServletContext().setAttribute("myGrade", myGrade);
				} else {
					request.getServletContext().setAttribute("myGrade", 0);
				}
			} else {
				request.getServletContext().setAttribute("myGrade", 0);
				request.getServletContext().setAttribute("joinflag", 0);
			}
		} else {
			request.getServletContext().setAttribute("isCollection", "fail");
			request.getServletContext().setAttribute("myGrade", 11);
		}
		// �õ��γ̵������Ϣ
		Course c = courseDetailServiceImpl.getCourse(courseId);
		request.getServletContext().setAttribute("course", c);

		// �õ�ѧϰ�˿γ̵�����
		int studyPeople = courseDetailServiceImpl.getStudyCoursePeople(courseId);
		request.getServletContext().setAttribute("studypeople", studyPeople);

		// �����ùؿγ̵����۲���ʾ����
		Page<CourseComment> pageCommentList = courseCommentServiceImpl.pageCourseComment(pageNum, 4, courseId);
		request.getServletContext().setAttribute("pageCommentList", pageCommentList);
		request.getServletContext().setAttribute("commentList", pageCommentList.getList());

		// ͨ���γ̺��ҵ��ϴ��γ̵���
		int cu = courseDetailServiceImpl.getCourseUserId(courseId);

		// ͨ��userid�ҵ���Ӧ����
		User uploadCourseUser = courseDetailServiceImpl.getCourseUser(cu);
		request.getServletContext().setAttribute("uploadCourseUser", uploadCourseUser);

		// ͨ��userid�ҵ��ϴ��γ̵�����
		int uploadCourseCount = courseDetailServiceImpl.getUserUploadCourse(cu);
		request.getServletContext().setAttribute("uploadCourseCount", uploadCourseCount);

		// �õ���˿γ�������ͬ�������γ�
		List<Course> listCourse = courseDetailServiceImpl.listCourse(courseId);
		Map<Course, Integer> mpc = new LinkedHashMap<Course, Integer>();
		for (Course temp : listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);
		// �ж�����û��Ƿ��Ѿ�������˿γ�
		boolean b = courseDetailServiceImpl.isJoin(uid, courseId);
		if (b) {
			request.getServletContext().setAttribute("isj", 1);
		} else {
			request.getServletContext().setAttribute("isj", 0);
		}
		request.getServletContext().setAttribute("btn", "btn");
		request.getServletContext().setAttribute("uemail", semail);
		request.getServletContext().setAttribute("courseId", courseId);
		return "coursecomment";
	}

	@RequestMapping("/insertCourseComment")
	@ResponseBody
	public void insertCourseComment(@RequestParam("courseId") int courseId,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam("text") String text,
			HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		String semail = "";
		int userId=0;
		Object email = session.getAttribute("email");
		// ����û���Ϊ�գ��ͽ����ݲ��뵽���ݿ���
		if (email != null) {
			semail = (String) session.getAttribute("email");
			// ͨ���û�id�ҵ����û�
			userId = uploadServiceImpl.getUserIdByEmail(semail);
			Course c = courseDetailServiceImpl.getCourse(courseId);
			User u = courseDetailServiceImpl.getCourseUser(userId);
			CourseComment courseComment = new CourseComment();
			courseComment.setCommentTime(new Date());
			courseComment.setText(text);
			courseCommentServiceImpl.insertCourseComment(courseComment, c, u);
			List<CourseComment> listCourseComment = courseCommentServiceImpl.getCourseCommentLast();
			List<Object[]> data=new ArrayList<Object[]>();
			// �ж�����û��Ƿ��Ѿ�������˿γ�
			boolean b = courseDetailServiceImpl.isJoin(userId, courseId);
			for(CourseComment cc:listCourseComment) {
				if(b) {
					Object[] a= {cc.getUser().getPhoto(),cc.getUser().getNickName(),cc.getCourseCommentId(),cc.getCommentTime(),1};
					data.add(a);
				}else {
					Object[] a1= {cc.getUser().getPhoto(),cc.getUser().getNickName(),cc.getCourseCommentId(),cc.getCommentTime(),0};
					data.add(a1);
				}
			}
			System.out.println(data);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(JSON.toJSONString(data));
		} else {
			response.getWriter().print("false");
		}
	}

	@RequestMapping("/insertAnswerCourseComment")
	@ResponseBody
	public String insertCourseComment(@RequestParam("courseId") int courseId, @RequestParam("text") String content,
			@RequestParam("commentPid") int courseCommentId, @RequestParam("oHfTop") String oHfTop,
			HttpServletResponse response, HttpSession session) {
		String result = "";
		Object obj = session.getAttribute("email");
		if (obj == null) {
			result = "emailempty";
			return result;
		} else {
			String semail = (String) session.getAttribute("email");
			int userId = uploadServiceImpl.getUserIdByEmail(semail);
			Course c = courseDetailServiceImpl.getCourse(courseId);
			User u = courseDetailServiceImpl.getCourseUser(userId);
			CourseComment courseComment = courseCommentServiceImpl.getCourseComment(courseCommentId);

			CourseComment newCourseComment = new CourseComment();
			newCourseComment.setCommentTime(new Date());
			newCourseComment.setText(content);
			newCourseComment.setTop(Integer.parseInt(oHfTop));
			boolean insertCourseCommentAnswer = courseCommentServiceImpl.insertCourseCommentAnswer(courseComment,
					newCourseComment, c, u);
			if (insertCourseCommentAnswer) {
				result = "ok";
				return result;
			} else {
				result = "false";
				return result;
			}
		}
	}

	@RequestMapping(value = "/findsoncomment", method = RequestMethod.POST)
	public void findSonComment(HttpServletRequest request, HttpServletResponse response) {
		List<CourseComment> comments = courseCommentServiceImpl
				.FindSon(Integer.parseInt(request.getParameter("oHfTop")));
		List<Object[]> name = new ArrayList<Object[]>();
		for (CourseComment c : comments) {
			Object[] aObjects = { c.getCourseCommentId(), (Date) c.getCommentTime(), c.getText(),
					c.getCourseComment().getUser().getNickName(), c.getUser().getNickName() };
			System.out.println((Date) c.getCommentTime());
			name.add(aObjects);
		}
		response.setCharacterEncoding("UTF-8");
		// comment=commentServiceImpl.FindOne(objects);
		System.out.println("comment2:" + comments);
		PrintWriter out = null;
		// SimplePropertyPreFilter filter=new
		// SimplePropertyPreFilter(Comment.class,"commentId","text","user");
		try {
			out = response.getWriter();
			System.out.println(JSON.toJSONString(name));
			out.print(JSON.toJSONString(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/makeScore")
	@ResponseBody
	public double makeScore(HttpServletRequest request, @RequestParam("courseId") int courseId,
			@RequestParam("grade") int grade) {
		String email = (String) request.getSession().getAttribute("email");
		User loginPerson = this.informationServiceImpl.getTheUserByEmail(email);
		Course gradeCourse = this.courseCommentServiceImpl.getCourseById(courseId);
		this.courseCommentServiceImpl.giveGrade(loginPerson, gradeCourse, grade);
		double myGrade = this.courseCommentServiceImpl.findTheGrade(loginPerson, gradeCourse).getGrade();
		double result = myGrade;
		double sumGrade = 0;
		List<Grade> courseGrades = this.courseCommentServiceImpl.listGrounds(courseId);
		for (Grade g : courseGrades) {
			sumGrade += g.getGrade();
		}
		double avgGrade = sumGrade / courseGrades.size();
		this.courseCommentServiceImpl.updateGrade(avgGrade, courseId);
		System.out.print("hahahha");
		return result;
	}
}