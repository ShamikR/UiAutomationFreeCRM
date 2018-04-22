package com.freecrm.uiAutomation.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	// define counter
	int counter = 0;

	// define max count
	int retryLimit = 2;

	//  Overridden method 
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

}
