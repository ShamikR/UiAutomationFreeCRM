package com.freecrm.uiAutomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {
	private static Actions act;

	public static void mouseHoverToElement(WebDriver driver, WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element);
		act.build().perform();
	}

}
