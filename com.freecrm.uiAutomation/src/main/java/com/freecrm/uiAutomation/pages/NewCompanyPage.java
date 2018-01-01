package com.freecrm.uiAutomation.pages;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class NewCompanyPage extends TestBase {

	private Select oSelect;
	private final Logger log = LoggerUtil.getLogger(NewCompanyPage.class);
	@FindBy(css = "#company_name")
	WebElement companyName;
	@FindBy(css = "select[name='status']")
	WebElement selectStatus;
	@FindBy(css = "input[value='Lookup'][type='button']")
	WebElement lookupCompany;
	@FindBy(xpath = "//form[@id='companyForm']//input[@value='Save' and @type='submit']")
	List<WebElement> listSaveBtn;

	public NewCompanyPage() {
		PageFactory.initElements(driver, this);
	}

	public void setCompanyName(String cName) {
		log.info("Setting company name as:- " + cName);
		companyName.sendKeys(cName);
	}

	public void setCompanyStatus(String cStatus) {
		oSelect = new Select(selectStatus);
		log.info("Setting company status as:- " + cStatus);
		oSelect.selectByVisibleText(cStatus);
	}

	public String getParentWindowID() {
		return driver.getWindowHandle();
	}

	public void clickOnLookUpCompany() {
		log.info("Clicking on lookup company button..");
		lookupCompany.click();
	}

	public void selectLookupCompany(String lookUpCompanyName) {
		String parentWindow = getParentWindowID();
		System.out.println(parentWindow);
		Set<String> Setwindow = driver.getWindowHandles();
		//System.out.println(Setwindow.size());
		for (String handle : Setwindow) {
			if (handle != parentWindow) {
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.cssSelector("#search")).sendKeys(lookUpCompanyName);
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		driver.findElement(By.cssSelector("td.datafield>a")).click();
		String parentWindow1 = getParentWindowID();
		System.out.println(parentWindow1);
		driver.switchTo().defaultContent();
	}

	public void clickOnSaveButton() {
		log.info("Clicking on save button..");
		listSaveBtn.get(0);
	}
}
