package com.freecrm.uiAutomation.pages;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.WaitUtil;

public class ContactLookUpPage extends TestBase{
	
	private static final Logger Log = LoggerUtil.getLogger(ContactLookUpPage.class);
	
	@FindBy(xpath = "//form[@id='lookupSearchForm']//input[@id='search']")
	private WebElement searchBox;
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searcBtn;
	@FindBy(xpath = "//a")
	private List<WebElement> links;
	
	
	public void enterValueInSearchBox(String searchVal) {
		Log.info("Entering seacrh value - " + searchVal);
		WaitUtil.waitForElement(searchBox);
		searchBox.sendKeys(searchVal);
	}
	
	public void clickOnSearchbtn() {
		Log.info("Clicking on Search button..");
		searcBtn.click();
	}
	
	public void selectFirstLink() {
		Log.info("Selecting First link..");
		links.get(0).click();
	}

}
