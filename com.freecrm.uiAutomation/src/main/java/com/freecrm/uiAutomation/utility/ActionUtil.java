package com.freecrm.uiAutomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.freecrm.uiAutomation.base.TestBase;

public class ActionUtil extends TestBase{
	private static Actions act;
	
	static {
		act = new Actions(driver);
	}

	public static void mouseHoverToElement(WebDriver driver, WebElement element) {
		act.moveToElement(element);
		act.build().perform();
	}
	
	public static void dragAndDrop(WebElement fromEle, WebElement toEle) {
		act.dragAndDrop(fromEle, toEle);
		act.build().perform();
	}

}
