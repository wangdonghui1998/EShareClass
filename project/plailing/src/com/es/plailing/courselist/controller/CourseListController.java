package com.es.plailing.courselist.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.es.plailing.courselist.service.CourseListServiceImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Page;
/**
 * 
    * @ClassName: CourseListController
    * @Description: TODO(courselistҳ�Ŀ�����)
    * @author ������
    * @date 2018��11��28��
    *
 */
@Controller
public class CourseListController {
	@Resource
	private CourseListServiceImpl courseListServiceImpl;
/**
 * 
    * @Title: courseListAll
    * @Description: TODO(��ѯcourselistҳ��ȫ���γ̵�����)
    * @param @param request
    * @param @return    ����
    * @return String    ��������
    * @throws
 */
	@RequestMapping("/courseListAll")
	public String courseListAll(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		List<CourseType> parentType = new ArrayList<CourseType>();
		parentType = courseListServiceImpl.listAllCoursePareType();
		List<Course> listHotCourse = this.courseListServiceImpl.listCourseHotCourses();
		request.getServletContext().setAttribute("listHotCourse",listHotCourse);
		request.getServletContext().setAttribute("parentType",parentType);
		request.setAttribute("mTag","�Ƽ�");
		//��ҳ��ѯ�γ�
		int total = this.courseListServiceImpl.listAllCourses().size();
		System.out.print(total);
		System.out.print("helloworld");
		Page<Course> page = courseListServiceImpl.listAllCoursesPage(pageNum, 12,total);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page", page);
		request.setAttribute("tag","ac");
		return "courselist";
	}
	/**
	 * 
	    * @Title: courseListF
	    * @Description: TODO(��ѯcourselistҳ�游���Ϳγ̵�����)
	    * @param @param request
	    * @param @param fTypeId
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/courseListF")
	public String courseListF(@RequestParam(value="pageNum",defaultValue="1") int pageNum,HttpServletRequest request,@RequestParam("fTypeId") int fTypeId){
		CourseType fCourseType = courseListServiceImpl.getPareType(fTypeId);
		List<CourseType> cCourseTypes = this.courseListServiceImpl.listCoursesChildType(fTypeId);
		request.getServletContext().setAttribute("cCourseTypes",cCourseTypes);
		Page<Course> page = this.courseListServiceImpl.listParentCoursesPage(pageNum, 12, fCourseType);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page",page);
		request.setAttribute("mTag","ȫ��");
		request.setAttribute("fTypeId",fTypeId);
		request.setAttribute("tag","ftc");
		return "courselist";
	}
	/**
	 * 
	    * @Title: courseListT
	    * @Description: TODO(��ѯcourselistҳ�������Ϳγ̵�����)
	    * @param @param request
	    * @param @param pageNum
	    * @param @param cTypeId
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/courseListT")
	public String courseListT(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam("cTypeId") int cTypeId){
		//�������ͷ�ҳ��ѯ�γ�
		CourseType cCourseType = this.courseListServiceImpl.getPareType(cTypeId);
		Page<Course> page = this.courseListServiceImpl.listChildCoursesPage(pageNum, 12, cCourseType);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page",page);
		request.setAttribute("mTag","ȫ��");
		request.setAttribute("cTypeId",cTypeId);
		request.setAttribute("tag","ctc");
		request.setAttribute("fTypeId",cCourseType.getCourseType().getTypeId());
		return "courselist";
	}
	
}
