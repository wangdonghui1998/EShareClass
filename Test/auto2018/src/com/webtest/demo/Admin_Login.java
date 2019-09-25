package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Login extends BaseTest {
	/**
	 * @author wangdonghui
	 */
//	@Test
//	public void testLogin() {
//		// 打开网页
//		webtest.open("http://localhost:8080/plailing/main.jsp ");
//		// 登录
//		webtest.click("xpath=//a[@class='btn btn-default navbar-btn sign-in']");
//		webtest.typeAndClear("xpath=//input[@id='lemail']", "15226538851@163.com");
//		webtest.typeAndClear("xpath=//input[@id='lpassword']", "12345");
//		// 点击登录
//		webtest.click("xpath=//button[contains(.,'登录')]");
//
//	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, 2);
	}
}
