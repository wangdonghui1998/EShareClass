package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.webtest.utils.ReadProperties;
/**
 * author:lihaunzhen
 */
public class SeleniumScreenShot {
    public WebDriver driver;
 
    public SeleniumScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public void screenShot(String name){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		
		File s_file=((TakesScreenshot)driver).
				getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s_file, new File(ReadProperties.getPropertyValue("failpic") + name +nowDateTime+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}