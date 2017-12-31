package com.freecrm.uiAutomation.NewContactsPageTest;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.ContactsPage;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.pages.NewContactPage;
import com.freecrm.uiAutomation.utility.ExcelUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_CreateNewContacts extends TestBase{
	private LoginPage objLoginPage;
	private HomePage objHomePage;
	private ContactsPage objContactPage;
	private NewContactPage objNewContactPage;
	private final Logger log = LoggerUtil.getLogger(TC001_CreateNewContacts.class);
	private ExcelUtil objExcelUtil;
	
	@DataProvider
	private String[][] getData() throws Exception {
		objExcelUtil = new ExcelUtil();
		return objExcelUtil.getTestData("NewContact");
	}
	
	
	@Test (dataProvider = "getData")
	public void testCreateNewContacts(String title, String fName, String lName) {
		log.info("Executing test case:- TC001_CreateNewContacts");
		objLoginPage = new LoginPage();
		objHomePage = objLoginPage.login(obj.getUserName(), obj.getPassword());
		objContactPage = objHomePage.clickOnContactsLink();
		objNewContactPage = objContactPage.clickOnNewContactBtn();
		//objNewContactPage.createNewContact(title, fName, lName);
		objNewContactPage.setTitle(title);
		objNewContactPage.setFirstName(fName);
		objNewContactPage.setLastName(lName);
		objNewContactPage.clickOnSaveBtn();
		objHomePage.logOut();
	}

}
