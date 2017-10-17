package com.freecrm.uiAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.freecrm.uiAutomation.base.TestBase;

public class NewEventPage extends TestBase{
	
	@FindBy(css = "#title")
	WebElement eventTitle;
	@FindBy(xpath = "//*[@title='Date selector']")
	List<WebElement>listCalender;
	
	public void selectDateFromCalender() {
		String dateMonth = driver.findElement(By.xpath("//div[@class='calendar']/table/thead/tr/td[2]")).getText();
	}
	
}
