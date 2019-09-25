package com.es.plailing.relatecourseinform.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.relatecourseinform.service.CourseInformServiceImpl;

/**
 * 
    * @ClassName: CourseInformController
    * @Description: TODO(ͨ��������ȡ�γ�֪ͨ)
    * @author ������
    * @date 2018��12��19��
    *
 */

@Controller
public class CourseInformController {

	@Resource
	private CourseInformServiceImpl courseInformServiceImpl;
	
	/**
	 * 
	    * @Title: getRelate
	    * @Description: TODO(��ȡ����γ�֪ͨ)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */

	@RequestMapping("/relate")
	public String getRelate(HttpServletRequest request,
			@RequestParam(value = "pageNum", required = true, defaultValue = "1") int pageNum) {

		User user = (User) request.getServletContext().getAttribute("leftUser");
		// ��ȡ����Ŀγ�
		List<UserJoinCourse> joinCourse=courseInformServiceImpl.find(user.getUserId());
		Map<List<Inform>, Integer> listInformAll = new LinkedHashMap<List<Inform>, Integer>();		
//		Page<Inform> pageInform = new Page<Inform>();
		
		for (UserJoinCourse c : joinCourse) {
			
			List<Inform> listInform = courseInformServiceImpl.findInform(c.getCourse().getCourseId());
			listInformAll.put(listInform, c.getCourse().getCourseId());

		}
		request.getServletContext().setAttribute("listInformAll", listInformAll);
		//��ҳ
		Page<Inform> pageInform=courseInformServiceImpl.findPage(pageNum, 10, user.getUserId());
		request.getServletContext().setAttribute("pageInform", pageInform);
		
		return "relate";

	}
}
