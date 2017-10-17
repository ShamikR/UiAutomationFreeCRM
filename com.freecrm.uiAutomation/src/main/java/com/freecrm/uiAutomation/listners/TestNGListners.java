package com.freecrm.uiAutomation.listners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.DateTimeUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class TestNGListners extends TestBase implements ITestListener {

	private final Logger log = LoggerUtil.getLogger(TestNGListners.class);

	public void onTestStart(ITestResult result) {
		log("Test Started:- " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log("Test Passed:- " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String strPath = new File(System.getProperty("user.dir")).getAbsolutePath() + "/failedScrenShoot"+"/"+DateTimeUtil.getCurrentDateTime()+"/";
			File scrDestFile = new File(strPath + result.getName() + "_" + DateTimeUtil.getCurrentDateTime() + ".png");
			FileUtils.copyFile(scrFile, scrDestFile);
			Reporter.log("<a href = '" + scrDestFile.getAbsolutePath() + "' > <img src = '"
					+ scrDestFile.getAbsolutePath() + "' hight = '150' width = '150' /> <a/>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		log("Test Skipped:- " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	private void log(String msg) {
		log.info(msg);
		Reporter.log(msg);
	}

}
