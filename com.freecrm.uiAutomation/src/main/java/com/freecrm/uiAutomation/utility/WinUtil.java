package com.freecrm.uiAutomation.utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WinUtil {

	public static void switchToFrame(WebDriver driver, String frame) {
		driver.switchTo().frame(frame);
	}

	public static void switchBackToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static String getParentWinId(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static void switchToChildWindow(WebDriver driver, String parentId) {
		Set<String> winIds = driver.getWindowHandles();
		System.out.println(winIds.size());

		for (String win : winIds) {
			if (!win.equalsIgnoreCase(parentId)) {
				driver.switchTo().window(win);
				driver.manage().window().maximize();
				System.out.println("switch to child win - " + win);
			}
		}
	}

	public static void switchToParentWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
	}

}
