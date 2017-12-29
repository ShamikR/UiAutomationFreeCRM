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
	@FindBy(css = "td>input[value='Save'][class='button']")
	List<WebElement> listSaveBtn;

	public NewCompanyPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewCompany(String cName, String cStatus, String lookUpCompanyName) {
		companyName.sendKeys(cName);
		oSelect = new Select(selectStatus);
		oSelect.selectByVisibleText(cStatus);
		String parentWindow = driver.getWindowHandle();
		lookupCompany.click();
		Set<String> Setwindow = driver.getWindowHandles();
		// Iterator<String> it = Setwindow.iterator();
		for (String handle : Setwindow) {
			if (handle != parentWindow) {
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.cssSelector("#search")).sendKeys(lookUpCompanyName);
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		driver.findElement(By.cssSelector("td.datafield>a")).click();
	}

}
