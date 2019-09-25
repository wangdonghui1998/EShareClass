package com.es.plailing.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
    * @ClassName: PersonalFilter
    * @Description: TODO(����ǰ̨û�е�¼��¼�������ĵ�����)
    * @author ������
    * @date 2018��12��11��
    *
 */
public class PersonalFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		Object object = request.getSession().getAttribute("email");
		//ǰ̨�������û�е�¼
		if(object!=null) {
			chain.doFilter(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
