package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.uiAutomation.base.TestBase2;
import com.freecrm.uiAutomation.utility.ActionUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class HomePageSnapDeal extends TestBase2 {
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	WebElement signIn;
	@FindBy(xpath = "//a[contains(text(),'login')]")
	WebElement btnLogin;
	
	private final Logger log = LoggerUtil.getLogger(HomePageSnapDeal.class);
	
	public HomePageSnapDeal() {
		PageFactory.initElements(driver, this);
	}
	
	public void movetoSignIn() {
		log.info("Movin to Element - SignIn");
		ActionUtil.mouseHoverToElement(driver, signIn);
	}
	
	public void clickOnLogin() {
		btnLogin.click();
	}

}
