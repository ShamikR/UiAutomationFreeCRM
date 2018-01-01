package com.freecrm.uiAutomation.utility;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.uiAutomation.base.TestBase;

public class WaitUtil extends TestBase {

	private WebDriverWait wait;

	public WebElement waitForElement(WebElement element) {
		wait = new WebDriverWait(driver, obj.getExplicitWait());
		wait.pollingEvery(5, TimeUnit.SECONDS);
		WebElement resultElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return resultElement;
	}

	public WebElement fluentWait(WebElement element) {
		WebElement fWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		return fWait;
	}
	
	public void javaScreipWait() {
		ExpectedCondition<Boolean> javaScWait = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver_) {
				driver_ = driver;
				return ((JavascriptExecutor)driver_).executeScript("return document.readyState").equals("complete");
			}
			
		};
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(javaScWait);
		} catch (Exception e) {
			System.out.println("Timeout Waiting for page load request to complete after "+60+"seconds");
		}
	}

}
