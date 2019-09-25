package com.webtest.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.webtest.core.SendReport;
import com.webtest.utils.ReadProperties;

public class Report_Test {
	/**
	 * @author wangdonghui
	 */
	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime = sdf.format(new Date());
		String srcDir = null;
		String filename = null;
		srcDir = ReadProperties.getPropertyValue("srcDir");
		filename = ReadProperties.getPropertyValue("filename") + ".zip";
		try {
			SendReport.sendReport(srcDir, filename);
		} catch (Exception e) {
			System.out.println("文件找不到");
			e.printStackTrace();
		}
	}
}
