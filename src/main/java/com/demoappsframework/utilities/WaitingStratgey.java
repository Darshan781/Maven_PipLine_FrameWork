package com.demoappsframework.utilities;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;
import com.demoappsframework.Helper.ValidationHelper;

public class WaitingStratgey extends BaseUtility {
private	FluentWait<WebDriver> fluentWait;

     private static Logger log = LoggerUtility.getLogger(WaitingStratgey.class);
	
	public WaitingStratgey(WebDriver driver) {
		super(driver);
	
 fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                                    .ignoring(Exception.class);
	}
	
	public WebElement locateElement(By locator) {
		ValidationHelper.validateLocators(locator, "locateElement()");
		try {
			return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.info(ApplicationConstants.locateElementErrorMsgForWaitlog);
			throw new ApplicationExceptions(ApplicationConstants.locateElementErrorMsgForWait);
		}
		
	}
	
	public Alert switchToAlert() {
		try {
		return fluentWait.until(ExpectedConditions.alertIsPresent());	
		} catch (Exception e) {
			log.info(ApplicationConstants.switchToAlertErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.switchToAlertErrorMsg);
		}
	}
	
	public Boolean checkPageurl(String expectedPageUrl) {
		ValidationHelper.validateStringInput(expectedPageUrl, "checkPageurl()");
		try {
			return fluentWait.until(ExpectedConditions.urlContains(expectedPageUrl));
		} catch (Exception e) {
			log.info(ApplicationConstants.checkPageurlErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkPageurlErrorMsg);
		}
				
	}
	
    public Boolean checkPagetitle(String expectedPageTitle) {
    	ValidationHelper.validateStringInput(expectedPageTitle, "checkPageurl()");
    	try {
    		return fluentWait.until(ExpectedConditions.titleContains(expectedPageTitle));
		} catch (Exception e) {
			log.info(ApplicationConstants.checkPagetitleErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkPagetitleErrorMsglog);
		}
	}
    
    public WebElement checkClickable(By locator) {
    	ValidationHelper.validateLocators(locator, "checkClickable()");	
    	try {
        return fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			log.info(ApplicationConstants.checkClickableErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkClickableErrorMsg);
		}
	}
}
