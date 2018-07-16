package com.freecrm.uiAutomation.listners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class WebEventListners extends TestBase implements WebDriverEventListener {

	private final Logger log = LoggerUtil.getLogger(WebEventListners.class);

	public void beforeAlertAccept(WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {
	}

	public void afterAlertDismiss(WebDriver driver) {
	}

	public void beforeAlertDismiss(WebDriver driver) {
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Navigate to URL: " + url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Navigated to: " + driver.getCurrentUrl());
	}

	public void beforeNavigateBack(WebDriver driver) {
	}

	public void afterNavigateBack(WebDriver driver) {
	}

	public void beforeNavigateForward(WebDriver driver) {
	}

	public void afterNavigateForward(WebDriver driver) {
	}

	public void beforeNavigateRefresh(WebDriver driver) {
	}

	public void afterNavigateRefresh(WebDriver driver) {
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Trying to locate element: " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Element located " + by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("Clicking on element: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void onException(Throwable throwable, WebDriver driver) {
		/*
		String destinationPath = "";
		ScreenShotUtil.takeScreenShot(driver, destinationPath);
		*/
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
