package com.freecrm.uiAutomation.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
	private static final Logger log = LoggerUtil.getLogger(TestBase.class);
	public ConfigReader obj = new ConfigReader();
	public WebEventListners webListners;

	private static WebDriver getDriverInstance(BrowserType bType) throws Exception {
		try {
			switch (bType) {

			case chrome:
				log.info("Intiallizing chrome driver..");
				ChromeBrowser ch = new ChromeBrowser();
				return ch.getChromeDriver();

			case firefox:
				log.info("Intiallizing firefox driver..");
				FirefoxBrowser ff = new FirefoxBrowser();
				return ff.getFirefoxDriverr();

			default:
				log.info("Unable to initialize driver");
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
		log.info("Navigating to - " + obj.getAppURL());
		driver.manage().timeouts().pageLoadTimeout(obj.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(obj.getImplicitWait(), TimeUnit.SECONDS);
	}

	/*
	 * public String getFailsTestCaseScreenShotPath() {
	 * //System.out.println(ResourceUtil.getResourcePath("FailedTestScreenShot_"
	 * +DateTimeUtil.getCurrentDateTime())); return
	 * ResourceUtil.getResourcePath("FailedTestScreenShot_"+DateTimeUtil.
	 * getCurrentDateTime()); }
	 */
	@BeforeTest
	public void setUP() throws Exception {
		setUpDriver(obj.getBrowser());
	}

	@AfterTest
	public void tearDown() {
		log.info("Driver closed..");
		driver.close();
	}

	/*
	 * @BeforeSuite public void createFolder() { File f = new
	 * File(getFailsTestCaseScreenShotPath()); f.mkdir();
	 * //System.out.println(f.getAbsolutePath()); //return f.getAbsolutePath();
	 * }
	 */

}