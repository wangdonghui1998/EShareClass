package com.es.plailing.index.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
    * @ClassName: FilterController
    * @Description: TODO(�����Ƿ��¼�鿴��������ҳ��)
    * @author ������
    * @date 2018��12��11��
    *
 */
@Controller
public class FilterController {
	@RequestMapping("/pleaseLogin")
	@ResponseBody
	public String pleaseLogin(HttpServletRequest request) {
		String result = "fail";
		Object object = request.getSession().getAttribute("email");
		if(object!=null) {
			result = "pass";
			return result;
		}
		return result;
	}
}
