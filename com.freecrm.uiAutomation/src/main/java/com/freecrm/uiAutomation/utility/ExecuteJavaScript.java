package com.freecrm.uiAutomation.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExecuteJavaScript {
	
	public static void executeJs(WebDriver driver, String script) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript(script);
	}
	
	public static void executeJs(WebDriver driver, WebElement element, String script) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript(script, element);
	}

}
