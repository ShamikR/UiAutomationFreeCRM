package com.freecrm.uiAutomation.HomePageTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_VerifyHomePageTitle extends TestBase {

	private LoginPage objLoginPage;
	private HomePage objHomePage;
	private final Logger log = LoggerUtil.getLogger(TC001_VerifyHomePageTitle.class);

	@Test
	public void TC001_testHomePageTitle() {
		log.info("Executing Test Case:- TC001_VerifyHomePageTitle");
		objLoginPage = new LoginPage();
		objHomePage = objLoginPage.login(obj.getUserName(), obj.getPassword());
		String homePageTitle = objHomePage.getHomePageTitle();
		log.info("HomePage Title found as: " + homePageTitle);
		Assert.assertEquals(homePageTitle, "CRMPRO");
		objHomePage.logOut();
	}

}
