package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class LoginPage extends TestBase {
	private final Logger log = LoggerUtil.getLogger(LoginPage.class);

	@FindBy(xpath = "//input[@name='username']")
	WebElement loginUserName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement loginPassword;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * public HomePage login(String username, String password) {
	 * //driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	 * loginUserName.clear(); loginUserName.sendKeys(username); log.info("User
	 * Name:- " + username); loginPassword.clear();
	 * loginPassword.sendKeys(password); log.info("Password:- " + password);
	 * btnLogin.click(); return new HomePage(); }
	 **/
	public void setUserName(String username) {
		loginUserName.clear();
		log.info("User Name: " + username);
		loginUserName.sendKeys(username);
	}

	public void setPassword(String password) {
		loginPassword.clear();
		log.info("Password: " + password);
		loginPassword.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {
		btnLogin.click();
		log.info("Clicking on Login button");
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
