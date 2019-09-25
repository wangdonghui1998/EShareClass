package com.webtest.dataprovider;

import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.utils.ReadProperties;

public class NSDataProvider {
	public String sheet = null;
	
	@DataProvider(name = "custom_id")
	public Object[][] getTxtData2() throws IOException {
		return new TxtDataProvider().getTxtUser(ReadProperties.getPropertyValue("txt2_path"));
	}

//	@DataProvider(name = "user")
//	public Object[][] getExcelData1() throws IOException {
//		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("excel_path"),
//				"user");
//	}
	
	@DataProvider(name = "personalmessage")
	public Object[][] getExcelData2() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("excel_path"),
				"PersonalMessage");
	}
	
	
	@DataProvider(name = "user")
	public Object[][] getMysqlDada() throws IOException {
		return new MysqlDataProvider().getTestDataByMysql(
				"SELECT email, password,nickname FROM tbl_user "
		);
	}
	
	

}
