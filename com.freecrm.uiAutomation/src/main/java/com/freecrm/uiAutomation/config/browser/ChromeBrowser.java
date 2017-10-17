package com.freecrm.uiAutomation.config.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.freecrm.uiAutomation.utility.ResourceUtil;

public class ChromeBrowser {

	private Capabilities getChromeCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, options);

		return chrome;
	}

	public WebDriver getChromeDriver() {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", ResourceUtil.getResourcePath("src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(getChromeCapabilities());
		}

		else if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", ResourceUtil.getResourcePath("src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(getChromeCapabilities());
		}

		return null;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(System.getProperty("os.name")); }
	 */
}
