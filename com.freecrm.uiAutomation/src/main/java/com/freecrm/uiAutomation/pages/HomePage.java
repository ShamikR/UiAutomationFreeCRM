package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.ActionUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.PageElementUtil;
import com.freecrm.uiAutomation.utility.WaitUtil;
import com.freecrm.uiAutomation.utility.WinUtil;

public class HomePage extends TestBase {

	private static final Logger Log = LoggerUtil.getLogger(HomePage.class);
	//private WaitUtil wait = new WaitUtil();

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	private WebElement linkLogout;
	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement linkContacts;
	@FindBy(xpath = "//li/a[contains(.,'Calendar')]")
	private WebElement linkCalender;
	@FindBy(xpath = "//div[@id='navmenu']//a[contains(text(),'Companies')]")
	private WebElement linkCompany;
	@FindBy(xpath = "//div[@id='homebox_CALWEEK']//input[@title='New Event']")
	private WebElement iconNewEventFromWeekCalendar;

	public boolean isLoginSuccess() {
		WinUtil.switchToFrame(driver, "mainpanel");
		Log.info("checking presence of element : " + linkLogout);
		boolean flag = PageElementUtil.isElementPresent(linkLogout);
		WinUtil.switchBackToParentFrame(driver);
		return flag;
	}

	public void logOut() {
		try {
			WinUtil.switchToFrame(driver, "mainpanel");
			Log.info("Logging Out from app..");
			linkLogout.click();
			WinUtil.switchBackToParentFrame(driver);
		} catch (Exception e) {
			Log.info("Logging Out from app..");
			linkLogout.click();
		}
	}

	public ContactsPage clickOnContactsLink() {
		Log.info("Clicking on contact link..");
		WinUtil.switchToFrame(driver, "mainpanel");
		WaitUtil.javaScreipWait();
		WaitUtil.waitForElement(linkContacts).click();
		//linkContacts.click();
		return new ContactsPage();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void mouseHoverToContactsLink() {
		Log.info("Mouce Hovering to Contacts link..");
		ActionUtil.mouseHoverToElement(driver, linkContacts);
	}
	
	public void mouceHoverToCalenderLink() {
		Log.info("Mouce Hovering to Calender link..");
		ActionUtil.mouseHoverToElement(driver, linkCalender);
	}
	
	public NewEventPage selectNewEvent() {
		Log.info("Clicking on New Event..");
		driver.findElement(By.xpath("//li/a[contains(.,'New Event')]")).click();
		return new NewEventPage();
	}
	
	public void mouceHoverToCompany() {
		Log.info("Mpuce Hovering to company..");
		WinUtil.switchToFrame(driver, "mainpanel");
		ActionUtil.mouseHoverToElement(driver, linkCompany);		
	}
	
	public NewCompanyPage selectNewCompany() {
		Log.info("navigating to New Company link..");
		driver.findElement(By.cssSelector("a[title='New Company']")).click();
		return new NewCompanyPage();
	}
	
	public NewEventPage clickOnIconNewEventFromWeekCalendar() {
		WinUtil.switchToFrame(driver, "mainpanel");
		Log.info("Clicking on New Event Icon from week calendar..");
		WaitUtil.waitForElement(iconNewEventFromWeekCalendar).click();
		//iconNewEventFromWeekCalendar.click();
		return new NewEventPage();
		
	}
	
}
