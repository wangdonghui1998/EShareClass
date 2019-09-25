package com.es.plailing.checkinform.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.checkinform.service.CheckInformServiceImpl;
import com.es.plailing.coursecomment.service.CourseCommenServiceImpl;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: CheckInformController
    * @Description: TODO(ͨ��������ȡ�����Ϣ֪ͨ)
    * @author ������
    * @date 2018��12��19��
    *
 */
@Controller
public class CheckInformController {

	@Resource
	private CheckInformServiceImpl checkInformServiceImpl;
	
	/**
	 * 
	    * @Title: getCourseRelease
	    * @Description: TODO(ͨ��������ȡ�����Ϣ֪ͨ)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	
	@RequestMapping("/release")
	public String getCourseRelease(HttpServletRequest request,@RequestParam(value = "pageNum", required = true, defaultValue = "1") int pageNum) {
		
		//��ȡ�ϴ��γ�
		User user =(User) request.getServletContext().getAttribute("leftUser");
		System.out.println(user.getUserId());
		List<Inform> listInform=checkInformServiceImpl.findInform(user.getUserId());
		request.getServletContext().setAttribute("listInform", listInform);
		
		//��ҳ
		Page<Inform> pageRelease=checkInformServiceImpl.pageInform(pageNum, 10, user.getUserId());
		request.getServletContext().setAttribute("pageRelease", pageRelease);
		
		return "checkinform";
	}
}
