package com.demoapps.Listeners;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.demoapps.BrowserManager.BrowserFactory;
import com.demoappsframework.utilities.LoggerUtility;
import com.demoappsframework.utilities.ScreenShotUtility;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class ReportsListeners extends ChainTestListener implements ITestListener {
    
	private static Logger log = LoggerUtility.getLogger(ReportsListeners.class);
	
	public String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value = "{0}", type = "text/plain")
	public String getTextLog(String msg) {
		return msg;
	}

	@Attachment(value = "{0}", type = "text/html")
	public String getHtmlLog(String html) {
		return html;
	}

	public void onStart(ITestContext context) {
		log.info("Suite execution started \t"+ context.getName());
		Reporter.log("Suite execution started\t" + context.getName(), true);
		ChainTestListener.log("Suite execution started\t" + context.getName());
		super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		log.info("Suite execution finished \t"+ context.getName());
		Reporter.log("Suite execution finished\t" + context.getName(), true);
		ChainTestListener.log("Suite execution finished\t" + context.getName());
		super.onFinish(context);
	}

	public void onTestStart(ITestResult result) {
		log.info("Test execution started \t"+ result.getName());
		Reporter.log("Test execution started\t" + result.getName(), true);
		ChainTestListener.log("Test execution started\t" + result.getName());
		super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test execution success \t"+ result.getName());
		Reporter.log("Test execution Success", true);
		ChainTestListener.log("Test execution Success\t" + result.getName());
		super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test execution Failed \t"+ result.getName());
		System.out.println("Testcase execution have been failed :" + result.getName());
		Reporter.log("Test execution Failed\t" + result.getName(), true);
		ChainTestListener.log("Test execution Failed\t" + result.getName());
		super.onTestFailure(result);

		WebDriver driver = BrowserFactory.getDriver();
		if (driver != null) {

			byte[] image = ScreenShotUtility.getScreenShotBytes(driver);

			Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(image), ".png");

			ChainTestListener.embed(image, "image/png");
			log.info(getTestMethodName(result) + " method failed and screenshot captured for :" + result.getName());
			getTextLog(getTestMethodName(result) + " method failed and screenshot captured for :" + result.getName());
		}
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test execution skipped \t"+ result.getName());
		Reporter.log("Test execution Skipped\t" + result.getName(), true);
		ChainTestListener.log("Test execution Skipped\t" + result.getName());
		super.onTestSkipped(result);
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
		super.onTestFailedButWithinSuccessPercentage(iTestResult);
	}

}
