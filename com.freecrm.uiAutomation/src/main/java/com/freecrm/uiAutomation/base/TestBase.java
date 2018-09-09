package com.freecrm.uiAutomation.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.freecrm.uiAutomation.config.browser.BrowserType;
import com.freecrm.uiAutomation.config.browser.ChromeBrowser;
import com.freecrm.uiAutomation.config.browser.FirefoxBrowser;
import com.freecrm.uiAutomation.config.configreader.ConfigReader;
import com.freecrm.uiAutomation.listners.WebEventListners;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.PropertyFileReaderUtil;

public class TestBase {
	protected static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	private static final Logger Log = LoggerUtil.getLogger(TestBase.class);
	protected static ConfigReader obj = new ConfigReader();
	private WebEventListners webListners;

	public TestBase() {
		PageFactory.initElements(driver, this);
	}
	private static WebDriver getDriverInstance(BrowserType bType) throws Exception {
		try {
			switch (bType) {

			case chrome:
				Log.info("Intiallizing chrome driver..");
				ChromeBrowser ch = new ChromeBrowser();
				return ch.getChromeDriver();

			case firefox:
				Log.info("Intiallizing firefox driver..");
				FirefoxBrowser ff = new FirefoxBrowser();
				return ff.getFirefoxDriverr();

			default:
				Log.info("Unable to initialize driver");
				throw new Exception("Driver not found :- " + PropertyFileReaderUtil.getPropertiesValue("Browser"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void setUpDriver(BrowserType bType) throws Exception {
		driver = getDriverInstance(bType);
		e_driver = new EventFiringWebDriver(driver);
		webListners = new WebEventListners();
		e_driver.register(webListners);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.get(obj.getAppURL());
		Log.info("Navigating to - " + obj.getAppURL());
		// driver.manage().timeouts().pageLoadTimeout(obj.getPageLoadTimeOut(),
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(obj.getImplicitWait(),
		// TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setUP() throws Exception {
		setUpDriver(obj.getBrowser());
	}

	@AfterMethod
	public void tearDown() {
		Log.info("Driver closed..");
		driver.close();
	}

}