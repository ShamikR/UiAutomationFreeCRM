package com.freecrm.uiAutomation.LoginPageTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_VerifyPageTitle extends TestBase {
	private final Logger log = LoggerUtil.getLogger(TC001_VerifyPageTitle.class);
	private LoginPage objLoginPage;
	
	@Test
	public void TC001_testLoginPageTitle() {
		objLoginPage = new LoginPage();
		log.info("Executing Test Case:- TC001_testLoginPageTitle");
		Assert.assertEquals(objLoginPage.getLoginPageTitle(),"#1 Free CRM for Any Business: Online Customer Relationship Software1");
	}
	
}
