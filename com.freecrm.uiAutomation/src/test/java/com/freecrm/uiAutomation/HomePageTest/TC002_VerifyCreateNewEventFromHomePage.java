package com.freecrm.uiAutomation.HomePageTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.ContactLookUpPage;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.pages.NewEventPage;
import com.freecrm.uiAutomation.utility.ExcelUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.WinUtil;

public class TC002_VerifyCreateNewEventFromHomePage extends TestBase {

	private LoginPage objLoginPage;
	private HomePage objHomePage;
	private NewEventPage objNewEventPage;
	private ContactLookUpPage objContactLookUpPage;
	private final Logger Log = LoggerUtil.getLogger(TC001_VerifyHomePageTitle.class);

	@Test
	public void TC002_testCreateNewEventFromHomePage() throws Exception {

		ExcelUtil objExcelUtil = new ExcelUtil();

		Log.info("Executing Test Case:- TC002_VerifyCreateNewEventFromHomePage");
		objLoginPage = new LoginPage();
		objHomePage = objLoginPage.login(obj.getUserName(), obj.getPassword());
		objNewEventPage = objHomePage.clickOnIconNewEventFromWeekCalendar();
		objNewEventPage.setEventTitle(objExcelUtil.getDataFromExcel("NewEvent", "Event_Title", 1));
		objNewEventPage.setEventFromDate(objExcelUtil.getDataFromExcel("NewEvent", "Event_From_Date", 1));
		objNewEventPage.setEventEndDate(objExcelUtil.getDataFromExcel("NewEvent", "Event_End_Date", 1));
		objNewEventPage.checkAllDayEvent();
		objNewEventPage.checkAvailability();
		objNewEventPage.selectAssignToValue();
		String parentWinId = WinUtil.getParentWinId(driver);
		System.out.println(parentWinId);
		objContactLookUpPage = objNewEventPage.clickOnContactLookUp();
		WinUtil.switchToChildWindow(driver, parentWinId);
		objContactLookUpPage.enterValueInSearchBox(objExcelUtil.getDataFromExcel("NewEvent", "Search_Value", 1));
		objContactLookUpPage.clickOnSearchbtn();
		objContactLookUpPage.selectFirstLink();
		WinUtil.switchToParentWindow(driver, parentWinId);
		objNewEventPage.clickOnSaveBtn();

	}
}
