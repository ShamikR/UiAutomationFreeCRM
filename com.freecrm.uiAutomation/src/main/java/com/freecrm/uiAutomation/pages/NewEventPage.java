package com.freecrm.uiAutomation.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.ExecuteJavaScript;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.WaitUtil;
import com.freecrm.uiAutomation.utility.WinUtil;

public class NewEventPage extends TestBase {

	private static final Logger Log = LoggerUtil.getLogger(HomePage.class);

	// private final String SCRIPT1 =
	// "arguments[0].setAttribute('value','"+dateval+"');"

	@FindBy(css = "#title")
	private WebElement eventTitle;
	@FindBy(xpath = "//*[@title='Date selector']")
	private List<WebElement> listCalender;
	@FindBy(id = "fieldId_start")
	private WebElement fromDateField;
	@FindBy(id = "fieldId_end")
	private WebElement toDateField;
	@FindBy(id = "all_day_event")
	private WebElement allDayEventCheckBox;
	@FindBy(id = "validate_availability")
	private WebElement availabilityCheckBox;
	@FindBy(xpath = "//select[@name='assigned_to_user_id_src']//option")
	private List<WebElement> assignToValue;
	@FindBy(xpath = "//input[@value='==ADD==>']")
	private WebElement addAssignToButton;
	@FindBy(xpath = "//input[@name='contact_id']//following-sibling::input[@value='Lookup']")
	private WebElement contactLookUp;
	@FindBy(xpath = "//form[@id='appForm']//input[@value='Save']")
	private List<WebElement> saveBtn;

	public void setEventTitle(String title) {
		WaitUtil.waitForElement(eventTitle).sendKeys(title);
	}

	public void setEventFromDate(String dateVal) {
		WaitUtil.waitForElement(fromDateField);
		Log.info("Setting From Date to - " + dateVal);
		ExecuteJavaScript.executeJs(driver, fromDateField, "arguments[0].setAttribute('value','" + dateVal + "');");
	}

	public void setEventEndDate(String dateVal) {
		WaitUtil.waitForElement(toDateField);
		Log.info("Setting From Date to - " + dateVal);
		ExecuteJavaScript.executeJs(driver, toDateField, "arguments[0].setAttribute('value','" + dateVal + "');");
	}

	public void checkAllDayEvent() {
		Log.info("Checking all day event ..");
		allDayEventCheckBox.click();
	}

	public void checkAvailability() {
		Log.info("Checking availability ..");
		availabilityCheckBox.click();
	}

	public void selectAssignToValue() {
		Log.info("Selecting assign to value - " + assignToValue.get(0).getText());
		assignToValue.get(0).click();
	}

	public void clickOnAddAssignToButton() {
		Log.info("Clicking on add assign to button ..");
		addAssignToButton.click();
	}

	public ContactLookUpPage clickOnContactLookUp() {
		Log.info("Clicking on contact lookup..");
		contactLookUp.click();
		return new ContactLookUpPage();
	}
	
	public void clickOnSaveBtn() {
		WinUtil.switchToFrame(driver, "mainpanel");
		Log.info("Saving Evenet data ..");
		WaitUtil.waitForElement(saveBtn.get(1)).click();
	}

}
