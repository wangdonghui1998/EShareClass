package com.es.plailing.login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.entity.User;
import com.es.plailing.login.service.RegisterServiceImpl;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO(ע��͵�¼)
 * @author ������
 * @date 2018��12��6��
 *
 */
@Controller
public class LoginController {

	private int width = 140;// ����ͼƬ��width
	private int height = 32;// ����ͼƬ��height
	private int codeCount = 4;// ����ͼƬ����ʾ��֤��ĸ���
	private int xx = 25;
	private int fontHeight = 28;
	private int codeY = 26;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	@Resource
	private RegisterServiceImpl registerServiceImpl;

	/**
	 * 
	 * @Title: getCode @Description: TODO(��ȡ��֤��) @param @param request @param @param
	 *         response @param @throws IOException ���� @return void �������� @throws
	 */
	@RequestMapping("/captcha")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// ����ͼ��buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		// ����һ���������������
		Random random = new Random();
		// ��ͼ�����Ϊ��ɫ
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// �������塣
		gd.setFont(font);
		// ���߿�
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);
		// �������40�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 40; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// �������codeCount���ֵ���֤�롣
		for (int i = 0; i < codeCount; i++) {
			// �õ������������֤�����֡�
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// �������������ɫ����֤����Ƶ�ͼ���С�
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);
			// ���������ĸ�����������һ��
			randomCode.append(code);
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = request.getSession();
		session.setAttribute("code", randomCode.toString());
		// ��ֹͼ�񻺴档
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// ��ͼ�������Servlet������С�
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

	/**
	 * 
	    * @Title: verify
	    * @Description: TODO(��֤���䡢���롢��֤�Ƿ���ȷ)
	    * @param @param email
	    * @param @param password
	    * @param @param captcha_v
	    * @param @param request
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/verify")
	@ResponseBody
	public String verify(@RequestParam("email") String email, @RequestParam("password") String password, 
			@RequestParam("captcha_v") String captcha_v,HttpServletRequest request) {
		// ������ʽ�����ʽ
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();

		// ������ʽ�������볤��
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern1 = Pattern.compile(passwordFormat);
		Matcher matcher1 = pattern1.matcher(password);
		boolean b1 = matcher1.matches();

		// ��ȡ��֤��
		String sb = (String) request.getSession().getAttribute("code");

		String result = "";
		if (b && b1 && sb.equals(captcha_v)) {
			result = "1";
			return result;
		} else if (!b && b1 && sb.equals(captcha_v)) {
			result = "2";
			return result;
		} else if (b && !b1 && sb.equals(captcha_v)) {
			result = "3";
			return result;
		} else if(b && b1 && !sb.equals(captcha_v)){
			result = "4";
			return result;
		}else if(!b && !b1 && sb.equals(captcha_v)){
			result = "5";
			return result;
		}else if(!b && b1 && !sb.equals(captcha_v)){
			result = "6";
			return result;
		}else if(b && !b1 && !sb.equals(captcha_v)){
			result = "7";
			return result;
		}else {
			result = "8";
			return result;
		}
	}
	
	/**
	 * 
	    * @Title: verifyEmail
	    * @Description: TODO(��֤���������ʽ)
	    * @param @param request
	    * @param @param email
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	
	@RequestMapping("/verifyEmail")
	@ResponseBody
	public String verifyEmail(HttpServletRequest request, @RequestParam("email") String email) {
		// ������ʽ�����ʽ
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp=0;
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				temp += 1;
			}
		}
		
		String result = "";
		if (b && temp==0) {
			result = "email pass";
			return result;
		} else if(b && temp==1){
			result = "email exist";
			return result;
		}else {
			result ="email not pass";
			return result;
		}
	}
	
	/**
	 * 
	    * @Title: verifyPassword
	    * @Description: TODO(��֤���������ʽ)
	    * @param @param request
	    * @param @param password
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */

	@RequestMapping("/verifyPassword")
	@ResponseBody
	public String verifyPassword(HttpServletRequest request, @RequestParam("password") String password) {
		// ������ʽ�������볤��
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(password);
		boolean b = matcher.matches();
		String result = "";
		if (b) {
			result = "password pass";
			return result;
		} else {
			result = "password not pass";
			return result;
		}
	}

	/**
	 * 
	 * @Title: registeUser @Description: TODO(�û�ע��) @param @param
	 *         request @param @param response @param @param email @param @param
	 *         password @param @param captcha_v @param @return @param @throws
	 *         IOException ���� @return String �������� @throws
	 */
	@RequestMapping("/register")
	public String registeUser(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("captcha_v") String captcha_v) throws IOException {

		// �����ʽ�ж�
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();

		// �����ʽ�ж�
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern1 = Pattern.compile(passwordFormat);
		Matcher matcher1 = pattern1.matcher(password);
		boolean b1 = matcher1.matches();

		// ��ȡ��֤��
		String sb = (String) request.getSession().getAttribute("code");
		User user = new User();
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		//��ȡ�û���ˮ��
		int num=listUser.size()+1;
		// �жϸ�Email�Ƿ������ݿ��Email�ظ�
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				temp += 1;
			}
		}

		// �ж��Ƿ����Ҫ��ĸ�ʽ
		if (b && temp == 0 && b1 && sb.equals(captcha_v)) {
			System.out.println("register");
			user.setEmail(email);
			user.setPassword(password);
			user.setPhoto("img/Linux&c.png");
			user.setNickName("Сe"+num);
			this.registerServiceImpl.insertUser(user);
			return "redirect:/index";
		} else {
			return "index";
		}
	}
	/**
	 * 
	    * @Title: verifyUser
	    * @Description: TODO(��֤�û���¼��Ϣ)
	    * @param @param email
	    * @param @param request
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */

	@RequestMapping("/verifyUser")
	@ResponseBody
	public String verifyUser(@RequestParam("email") String email, HttpServletRequest request) {
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		String result = "";
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				result = "email can use";
				return result;
			} else {
				temp += 1;
			}
		}
		if (temp == listUser.size()) {
			result = "email not exist";
			return result;
		} else {
			result = "email error";
			return result;
		}

	}

	/**
	 * 
	 * @Title: loginUser @Description: TODO(�û���¼) @param @param email @param @param
	 *         password @param @param request @param @param response @param @throws
	 *         IOException ���� @return void �������� @throws
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		String result = "false";
		for (User u : listUser) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				result = "true";
				request.getServletContext().setAttribute("user", u);
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				request.getServletContext().setAttribute("loginFlag", 1);
				return result;
			} else {
				temp += 1;
			}
		}
		return result;
	}
	
	/**
	 * 
	    * @Title: quit
	    * @Description: TODO(�˳���¼)
	    * @param @param request
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request) {
		String email=(String) request.getSession().getAttribute("email");
		if(email != null) {
			HttpSession session=request.getSession();
			session.setAttribute("email", null);
			request.getServletContext().setAttribute("loginFlag", 0);
			return "index";
		}else {
			request.getServletContext().setAttribute("loginFlag", 0);
			return "index";
		}		
	}
}
