package com.freecrm.uiAutomation.config.configreader;

import com.freecrm.uiAutomation.config.browser.BrowserType;

public interface Config {
	public String getUserName();
	public String getPassword();
	public String getAppURL();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}
