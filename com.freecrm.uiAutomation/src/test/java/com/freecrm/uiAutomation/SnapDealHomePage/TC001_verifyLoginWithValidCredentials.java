package com.freecrm.uiAutomation.SnapDealHomePage;

import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase2;
import com.freecrm.uiAutomation.pages.HomePageSnapDeal;

public class TC001_verifyLoginWithValidCredentials extends TestBase2 {
	
	@Test
	public void TC001_testLoginWithValidCredentials() {
		HomePageSnapDeal objHommePage = new HomePageSnapDeal();
		objHommePage.movetoSignIn();
		objHommePage.clickOnLogin();
	}

}
