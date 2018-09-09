package com.freecrm.uiAutomation.LoginPageTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_VerifyPageTitle extends TestBase {
	private static final Logger Log = LoggerUtil.getLogger(TC001_VerifyPageTitle.class);
	private LoginPage objLoginPage;

	@Test
	public void TC001_testLoginPageTitle() {

		objLoginPage = new LoginPage();
		Log.info("Executing Test Case:- TC001_VerifyPageTitle");
		Log.info("Page Title - " + objLoginPage.getLoginPageTitle());
		Assert.assertEquals(objLoginPage.getLoginPageTitle(),
				"#1 Free CRM software in the cloud for sales and service");

		Log.info("----- END OF TEST CASE TC001_VerifyPageTitle -----");

	}
}
