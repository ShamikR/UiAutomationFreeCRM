package com.freecrm.uiAutomation.config.configreader;

import com.freecrm.uiAutomation.config.browser.BrowserType;
import com.freecrm.uiAutomation.utility.PropertyFileReaderUtil;

public class ConfigReader implements Config{

	public String getUserName() {
		return PropertyFileReaderUtil.getPropertiesValue("Username");
	}

	public String getPassword() {
		return PropertyFileReaderUtil.getPropertiesValue("Password");
	}

	public String getAppURL() {
		return PropertyFileReaderUtil.getPropertiesValue("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(PropertyFileReaderUtil.getPropertiesValue("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(PropertyFileReaderUtil.getPropertiesValue("ImplicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(PropertyFileReaderUtil.getPropertiesValue("ExplicitWait"));
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(PropertyFileReaderUtil.getPropertiesValue("Browser"));
	}

}
