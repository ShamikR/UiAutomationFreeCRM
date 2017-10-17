package com.freecrm.uiAutomation.ContactsPageTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.pages.ContactsPage;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_VerifyContactsPageLebel extends TestBase {
	
	private final Logger log = LoggerUtil.getLogger(TC001_VerifyContactsPageLebel.class);
	
	@Test
	public void TC001_testContactsPageLebel() {
		log.info("Excecuting Test: "+this.getClass().getName());
		HomePage objHomePahe = new HomePage();
		ContactsPage objContactPage = new ContactsPage();
		LoginPage objLoginPage = new LoginPage();
		objLoginPage.login(obj.getUserName(), obj.getPassword());
		objHomePahe.clickOnContactsLink();
		String name = objContactPage.getContactLevel();
		Assert.assertEquals(name, "Contacts");
	}

}
