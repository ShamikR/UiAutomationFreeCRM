package com.freecrm.uiAutomation.utility;

import org.openqa.selenium.WebDriver;

public class WinUtil {

	public static void switchToFrame(WebDriver driver, String frame) {
		driver.switchTo().frame(frame);
	}
	
	public static void switchBackToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

}
