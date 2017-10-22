package com.freecrm.uiAutomation.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class PageElementUtil {
	// WebDriver driver;
	private static Logger log = LoggerUtil.getLogger(PageElementUtil.class);

	public static boolean isElementPresent(WebElement ele) {
		try {
			ele.isDisplayed();
			log.info("Element Found - " + ele);
			return true;
		} catch (Exception e) {
			log.info("Unable to locate element - " + ele);
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}
}
