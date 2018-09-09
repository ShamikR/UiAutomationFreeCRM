package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class LoginPage extends TestBase {
	private static final Logger Log = LoggerUtil.getLogger(LoginPage.class);

	@FindBy(xpath = "//input[@name='username']")
	private WebElement loginUserName;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement loginPassword;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btnLogin;
	
	public void setUserName(String username) {
		loginUserName.clear();
		Log.info("User Name: " + username);
		loginUserName.sendKeys(username);
	}

	public void setPassword(String password) {
		loginPassword.clear();
		Log.info("Password: " + password);
		loginPassword.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {
		btnLogin.click();
		Log.info("Clicking on Login button");
		return new HomePage();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String username, String password) {
		setUserName(username);
		setPassword(password);
		return clickOnLoginButton();
	}
}
