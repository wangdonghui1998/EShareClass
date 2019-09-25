package com.es.plailing.coursedetail.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.upload.service.UploadService;


/**
 * 
    * @ClassName: CourseDetailController
    * @Description: ʵ��coursedetailҳ��
    * @author liushanshan
    * @date 2018��11��28��
    *
 */
@Controller
public class CourseDetailController {
	
	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private UploadService uploadServiceImpl;
	
	@RequestMapping("/courseDetail")
	public String showCourseDetail(HttpServletRequest request,@RequestParam("courseId") int courseId,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,HttpSession session) {
		String semail="";
		Object email=session.getAttribute("email");
		//�ж��ղش����������ʲô��״
		if(email!=null) {
		    semail=(String) session.getAttribute("email");
		    int uid=uploadServiceImpl.getUserIdByEmail(semail);
		    System.out.println(uid);
			//�ж�����γ��Ƿ��û��ղ�
			boolean isCollection=courseDetailServiceImpl.isCollection(uid, courseId);
			System.out.println(isCollection);
			if(isCollection) {
				request.getServletContext().setAttribute("isCollection", "ok");
			}else {
				request.getServletContext().setAttribute("isCollection", "fail");
			}
		}else {
			request.getServletContext().setAttribute("isCollection", "fail");
		}		
		//�õ��γ̵������Ϣ
		Course c=courseDetailServiceImpl.getCourse(courseId);
		request.getServletContext().setAttribute("course", c);
		
		//�õ�ѧϰ�˿γ̵�����
		int studyPeople=courseDetailServiceImpl.getStudyCoursePeople(courseId);
		request.getServletContext().setAttribute("studypeople", studyPeople);
		
		//�õ��γ̵�Ŀ¼
		Page<CourseCatalog> pageCatalogList=courseDetailServiceImpl.listCourseCatalog(pageNum,3,courseId);
		request.getServletContext().setAttribute("pageCatalogList", pageCatalogList);
		request.getServletContext().setAttribute("catalogList", pageCatalogList.getList());
		
		//ͨ���γ̺��ҵ��ϴ��γ̵���
		int cu=courseDetailServiceImpl.getCourseUserId(courseId);
		
		//ͨ��userid�ҵ���Ӧ����
		User uploadCourseUser=courseDetailServiceImpl.getCourseUser(cu);
		request.getServletContext().setAttribute("uploadCourseUser", uploadCourseUser);
		
		//ͨ��userid�ҵ��ϴ��γ̵�����
		int uploadCourseCount=courseDetailServiceImpl.getUserUploadCourse(cu);
		request.getServletContext().setAttribute("uploadCourseCount",uploadCourseCount);
		
		//�õ���˿γ�������ͬ�������γ�
		List<Course> listCourse=courseDetailServiceImpl.listCourse(courseId);
		Map<Course,Integer> mpc=new LinkedHashMap<Course,Integer>();
		for(Course temp:listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);
		request.getServletContext().setAttribute("email", semail); 
		

		request.getServletContext().setAttribute("uploaduser", cu);
		request.getServletContext().setAttribute("courseId", courseId);
		request.getServletContext().setAttribute("count", (pageNum-1)*3); 
		return "coursedetail";
	}
	
	@RequestMapping("/insertdetailCollection")
	public void isCollectioin(@RequestParam("courseId") int courseId,
			HttpServletResponse response,HttpSession session) throws IOException {
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);	
			Course course=courseDetailServiceImpl.getCourse(courseId);
			User user=courseDetailServiceImpl.getCourseUser(uid);
			boolean insertCollection=courseDetailServiceImpl.insertCollection(course, user);
			if(insertCollection) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}
	}
	
	@RequestMapping("/canceldetailCollection")
	public void canceldetailCollection(@RequestParam("courseId") int courseId,
			HttpServletResponse response,HttpSession session) throws IOException{
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);	
			boolean canceldetailCollection=courseDetailServiceImpl.updateCollection(courseId, uid);
			if(canceldetailCollection) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}
	}
	
	@RequestMapping("/detailJoin")
	public void isJoin(@RequestParam("courseId") int courseId,@RequestParam("uploadUser") int upuserId,
			HttpServletResponse response,HttpSession session) throws IOException {
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);
			Course course=courseDetailServiceImpl.getCourse(courseId);
			User u=courseDetailServiceImpl.getCourseUser(uid);
			User upu=courseDetailServiceImpl.getCourseUser(upuserId);
			//�ж�����û��Ƿ��Ѿ�������˿γ�
			boolean b=courseDetailServiceImpl.isJoin(uid, courseId);
			if(b) {
				response.getWriter().print("fail");
			}else {
				//�ж��˻�����Ƿ�С�ڿγ̵ļ۸�
				if(u.getBalance()<course.getPrice()) {
					response.getWriter().print("checkfail");
				}else{
					double totleMoney=u.getBalance()-course.getPrice();
					UserBalance ub=new UserBalance();
					ub.setTotleMoney(totleMoney);
					//д��Ǯ��ϸ
					boolean insertUserBalance=courseDetailServiceImpl.insertUserBalance(u, ub,course);
					//�޸��û������
					u.setBalance(totleMoney);
					boolean updateUser=courseDetailServiceImpl.updateUser(u);
					//���׬Ǯ��ϸ
					boolean insertMoney=courseDetailServiceImpl.insert(course, upu);
					//����Ϣ��д���ղؿγ���
					boolean insertJoin=courseDetailServiceImpl.insertJoin(u, course);
					//�޸Ŀγ���Ϣ
					course.setJoinCount(course.getJoinUsers().size());
					boolean courseJoinCount=courseDetailServiceImpl.updateCourse(course);
				
					if(insertUserBalance && updateUser && insertMoney && insertJoin && courseJoinCount) {
						response.getWriter().print("buy");
					}
				}
			}
		}
		
	}
	@RequestMapping("/study")
	@ResponseBody
	public String study(HttpServletRequest request, @RequestParam("courseId") int courseId) {
		String result="";
		Object obj=request.getSession().getAttribute("email");
		if(obj==null) {
			result="fail";
			return result;
		}else {
			String semail=(String)request.getSession().getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);
			//�ж�����û��Ƿ��Ѿ�������˿γ�
			boolean b=courseDetailServiceImpl.isJoin(uid, courseId);
			if(b) {
				result = "pass";
				return result;
			}else {
				result = "fail1";
				return result;
			}
		}
	}

}

