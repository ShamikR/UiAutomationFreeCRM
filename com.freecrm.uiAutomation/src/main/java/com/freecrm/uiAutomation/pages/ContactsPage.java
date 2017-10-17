package com.freecrm.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.uiAutomation.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement lblContacts;
	@FindBy(css = "input[value='New Contact']")
	WebElement newContactBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getContactLevel() {
		return lblContacts.getText();
	}
	
	public NewContactPage clickOnNewContactBtn() {
		newContactBtn.click();
		return new NewContactPage();
	}

}
