package com.es.plailing.forgetpwd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.entity.User;
import com.es.plailing.forgetpwd.service.ForgetPwdServiceImpl;
import com.es.plailing.update.service.UpdateServiceImpl;
import com.es.plailing.util.encrypt.UrlUtil;

/**
 * 
 * @ClassName: ForgetPwdController
 * @Description: TODO(forgetpwdҳ�Ŀ�����)
 * @author ������
 * @date 2018��12��8��
 *
 */
@Controller
public class ForgetPwdController {
	@Resource
	private ForgetPwdServiceImpl forgetPwdServiceImpl;
	@Resource
	private UpdateServiceImpl updateServiceImpl;
	private Map<String, Integer> loginEmails = new HashMap<String, Integer>();

	/**
	 * 
	 * @throws Exception 
	 * @Title: forgetPwd @Description: TODO(��������) @param @param
	 *         request @param @param email @param @return @param @throws IOException
	 *         ���� @return String �������� @throws
	 */
	@RequestMapping("/forgetPwd")
	@ResponseBody
	public String forgetPwd(HttpServletRequest request, @RequestParam("email") String email) throws Exception {
		String result = "fail";
		if (email == "") {
			result = "fail1";
			return result;
		}
		if (this.forgetPwdServiceImpl.getTheUser(email) == null) {
			result = "fail2";
			return result;
		}
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "SMTP");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("m15226538922", "zyllyr666");
			}
		});
		Message message = new MimeMessage(session);
		try {
			// ����5λ�����
			Random r = new Random();
			int randomNum = r.nextInt(90000) + 10000;
			String from = "m15226538922@163.com";
			String nick = "";
			try {
				nick = javax.mail.internet.MimeUtility.encodeText("e�����");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setFrom(new InternetAddress(nick + " <" + from + ">"));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("�޸�����");
			// ��email���м���
			String shamemail = UrlUtil.enCryptAndEncode(email);
			User user=updateServiceImpl.findUserInfo(email);
			message.setText("�û�,"+user.getNickName()+"���,ȷ���˻�����ֻ��ʹ��һ�Σ������û�н�����ز�����������յ��˴��ʼ���������ִ���κβ���������e��������뽫���ᱻ�޸ģ������޸�,�븴��������������������ַ���д�:"
			+ "http://localhost:8080/plailing/forgetpwd2.jsp?userEmail=" + shamemail + "&code=" + randomNum + "");
			message.setHeader("X-Mailer", "smtpsend");
			message.setSentDate(new Date());
			Transport.send(message);
			if (loginEmails.containsKey(shamemail)) {
				loginEmails.remove(shamemail);
				loginEmails.put(shamemail, randomNum);
			} else {
				loginEmails.put(shamemail, randomNum);
			}
			result = "ok";
			return result;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}

	/**
	 * 
	 * @Title: checkPwd @Description: TODO(����������ظ������Ƿ�һ��) @param @param
	 *         request @param @param pwd @param @param rpwd @param @return
	 *         ���� @return String �������� @throws
	 */
	@RequestMapping("/checkPwd")
	@ResponseBody
	public String checkPwd(HttpServletRequest request, @RequestParam("pwd") String pwd,
			@RequestParam("rpwd") String rpwd) {
		String result = "no pass";
		if (rpwd == "") {
			result = "pass";
		} else {
			if (pwd.equals(rpwd)) {
				result = "pass";
			}
		}
		return result;
	}

	/**
	 * @throws Exception
	 * 
	 * @Title: checkPwd1 @Description: TODO(�޸�����) @param @param
	 *         request @param @param pwd @param @param rpwd @param @param
	 *         email @param @return ���� @return String �������� @throws
	 */
	@RequestMapping("/checkPwd1")
	@ResponseBody
	public String checkPwd1(HttpServletRequest request, @RequestParam("pwd") String pwd,
			@RequestParam("rpwd") String rpwd, @RequestParam(value = "userEmail", required = false) String email,
			@RequestParam("code") int code) throws Exception {
		String result = "";
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(pwd);
		boolean b = matcher.matches();
		if (email == null || email.length() != 43 || !(loginEmails.containsKey(email))) {
			result = "fail1";
			return result;
		} else {
			// ��email���н���
			String realemail = UrlUtil.deCryptAndDecode(email);
			User u = this.forgetPwdServiceImpl.getTheUser(realemail);
			if (u != null && b && pwd.equals(rpwd) && (loginEmails.get(email) == code)) {
				this.forgetPwdServiceImpl.updateTheUserPwd(realemail, pwd);
				result = "pass";
				loginEmails.remove(email);
				return result;
			}
			if (email == null || u == null) {
				result = "fail1";
				return result;
			}
			if (!b) {
				result = "fail2";
				return result;
			}
			if (!(pwd.equals(rpwd))) {
				result = "fail3";
				return result;
			}
			return result;
		}
	}

	/**
	 * 
	 * @Title: checkPwd2 @Description: TODO(�޸�����ʱ�ж��û����������Ƿ���Ϲ淶) @param @param
	 *         request @param @param pwd @param @return ���� @return String
	 *         �������� @throws
	 */
	@RequestMapping("/checkPwd2")
	@ResponseBody
	public String checkPwd2(HttpServletRequest request, @RequestParam("pwd") String pwd) {
		String result = "no pass";
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(pwd);
		boolean b = matcher.matches();
		if (b) {
			result = "pass";
		}
		return result;
	}

	/**
	 * 
	 * @Title: checkEmail @Description: TODO(�һ�����ʱ�������) @param @param
	 *         request @param @param email @param @return ���� @return String
	 *         �������� @throws
	 */
	@RequestMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(HttpServletRequest request, @RequestParam("email") String email) {
		String result = "fail";
		if (this.forgetPwdServiceImpl.getTheUser(email) != null) {
			result = "ok";
		}
		if (email == "") {
			result = "fail1";
		}
		return result;
	}

}
