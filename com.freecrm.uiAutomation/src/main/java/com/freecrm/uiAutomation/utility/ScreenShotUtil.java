package com.freecrm.uiAutomation.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {

	public static void takeScreenShot(WebDriver driver, String destinationPath) {
		try {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File scrFile = sc.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(destinationPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public static void main(String[] args) {
		System.out.println(ResourceUtil.getResourcePath("FailedTestScreenShot"+DateTimeUtil.getCurrentDateTime()));
	}
	*/
}
