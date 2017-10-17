package com.freecrm.uiAutomation.config.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.freecrm.uiAutomation.utility.ResourceUtil;

public class FirefoxBrowser {

	private Capabilities getFirefoxCapabilities() {
		DesiredCapabilities fireFox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		fireFox.setCapability(FirefoxDriver.PROFILE, profile);
		fireFox.setCapability("marionette", true);

		return fireFox;
	}

	public WebDriver getFirefoxDriverr() {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", ResourceUtil.getResourcePath("src/main/resources/drivers/geckodriver"));
			return new FirefoxDriver(getFirefoxCapabilities());
		}

		else if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", ResourceUtil.getResourcePath("src/main/resources/drivers/geckodriver.exe"));
			return new FirefoxDriver(getFirefoxCapabilities());
		}

		return null;
	}
}
