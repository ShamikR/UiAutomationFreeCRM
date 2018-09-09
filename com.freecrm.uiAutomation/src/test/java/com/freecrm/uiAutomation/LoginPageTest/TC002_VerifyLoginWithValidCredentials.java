package com.freecrm.uiAutomation.LoginPageTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC002_VerifyLoginWithValidCredentials extends TestBase {
	private static final Logger Log = LoggerUtil.getLogger(TC002_VerifyLoginWithValidCredentials.class);
	public LoginPage objLoginPage;
	public HomePage objHomePage;

	@Test
	public void TC002_testValidLogin() {

		objLoginPage = new LoginPage();
		Log.info("Executing Test Case:- TC002_VerifyLoginWithValidCredentials");
		objHomePage = objLoginPage.login(obj.getUserName(), obj.getPassword());
		Assert.assertTrue(objHomePage.isLoginSuccess());
		objHomePage.logOut();

		Log.info("------ END OF TEST CASE TC002_VerifyLoginWithValidCredentials -----");

	}

}
