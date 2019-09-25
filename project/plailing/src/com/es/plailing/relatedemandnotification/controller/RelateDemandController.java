package com.es.plailing.relatedemandnotification.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatedemandnotification.service.RelateDemandServiceImpl;

/**
 * 
    * @ClassName: DemandController
    * @Description: TODO(ͨ��������ȡ����֪ͨ)
    * @author ������
    * @date 2018��12��19��
    *
 */
@Controller
public class RelateDemandController {

	@Resource
	private RelateDemandServiceImpl relatedemandServiceImpl;
	
	/**
	 * 
	    * @Title: getDemand
	    * @Description: TODO(��ȡ����֪ͨ)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/demandinform")
	public String getDemand(HttpServletRequest request,@RequestParam(value = "pageNum", required = true, defaultValue = "1") int pageNum) {
//		��������
		User user=(User) request.getServletContext().getAttribute("leftUser");
		List<Demand> listDemand=relatedemandServiceImpl.findDemand(user.getUserId());
		request.getServletContext().setAttribute("listDemand", listDemand);
		
		//��ҳ
		Page<Demand> pageDemand=relatedemandServiceImpl.pageDemand(pageNum, 10, user.getUserId());
		request.getServletContext().setAttribute("pageDemand", pageDemand);
		return "demandnotification";
	}
}
