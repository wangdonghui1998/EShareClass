package com.es.plailing.collection.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.collection.service.CollectionServiceImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserCollectionCourse;

/**
 * 
    * @ClassName: CollectionController
    * @Description: TODO(�γ��ղ�ҳ����ת)
    * @author ������
    * @date 2018��12��3��
    *
 */

@Controller
public class CollectionController {

	@Resource
	private CollectionServiceImpl collectionServiceImpl;
	
	/**
	 * 
	    * @Title: getCollection
	    * @Description: TODO(��ѯ�ղؿγ�)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/collection")
	public String getCollection(HttpServletRequest request,@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum) {		
		User user=(User) request.getServletContext().getAttribute("leftUser");
		//ѧϰ����
		String email=user.getEmail();
		List<Course> listCourse=collectionServiceImpl.findCourse(email);
		
		Map<Course,Integer> mpc=new LinkedHashMap<Course,Integer>();
		for(Course temp:listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);

		//��ҳ
		Page<Course> pageCourse=collectionServiceImpl.findPage(pageNum, 9,user.getEmail());		
		request.getServletContext().setAttribute("pageCourse", pageCourse);
		return "collection";
	}
	
	/**
	 * 
	    * @Title: deleteCollection
	    * @Description: TODO(��������״̬)
	    * @param @param request
	    * @param @param response
	    * @param @param courseId
	    * @param @throws IOException    ����
	    * @return void    ��������
	    * @throws
	 */
	@RequestMapping("/delete")
	public void deleteCollection(HttpServletRequest request,HttpServletResponse response, @RequestParam("courseId") int courseId) throws IOException {
		User user=(User) request.getServletContext().getAttribute("leftUser");		
		if(collectionServiceImpl.checkCourse(user.getUserId(), courseId)) {
			collectionServiceImpl.deleteCourse(user.getUserId(), courseId);
			response.getWriter().print("delete");			
		}else {
			response.getWriter().print("");
		}
		
	}
	
}
