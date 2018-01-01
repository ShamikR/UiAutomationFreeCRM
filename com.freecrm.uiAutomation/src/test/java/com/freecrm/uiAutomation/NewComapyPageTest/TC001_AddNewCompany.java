package com.freecrm.uiAutomation.NewComapyPageTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.config.configreader.ConfigReader;
import com.freecrm.uiAutomation.pages.HomePage;
import com.freecrm.uiAutomation.pages.LoginPage;
import com.freecrm.uiAutomation.pages.NewCompanyPage;
import com.freecrm.uiAutomation.utility.ExcelUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TC001_AddNewCompany extends TestBase {

	private final Logger log = LoggerUtil.getLogger(TC001_AddNewCompany.class);
	private LoginPage objLoginPage;
	private HomePage objHomePage;
	private NewCompanyPage objNewCompanyPage;
	private ExcelUtil objExcelReader;

	@Test
	public void testAddnewCompany() {
		try {
			objExcelReader = new ExcelUtil();
			objLoginPage = new LoginPage();
			objNewCompanyPage = new NewCompanyPage();
			ConfigReader objConfig = new ConfigReader();
			log.info("Login to Application ..");
			objHomePage = objLoginPage.login(objConfig.getUserName(), objConfig.getPassword());
			log.info("Moving mouce to company link ..");
			objHomePage.mouceHoverToCompany();
			objNewCompanyPage = objHomePage.selectNewCompany();
			String cName = objExcelReader.getDataFromExcel("NewCompany", "CompanyName", 1);
			log.info("Entered Company name as:-" + cName);
			objNewCompanyPage.setCompanyName(cName);
			String cStatus = objExcelReader.getDataFromExcel("NewCompany", "CompanyStatus", 1);
			log.info("Company Status:-" + cStatus);
			objNewCompanyPage.setCompanyStatus(cStatus);
			//log.info("Clicking on lookup company..");
			//objNewCompanyPage.clickOnLookUpCompany();
			//String lookUpCompanyName = objExcelReader.getDataFromExcel("NewCompany", "LookUpCompanyInput", 1);
			//log.info("Selected Company:- " + lookUpCompanyName);
			//objNewCompanyPage.selectLookupCompany(lookUpCompanyName);
			//driver.switchTo().window(objNewCompanyPage.getParentWindowID());
			objNewCompanyPage.clickOnSaveButton();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
		}

	}
}
