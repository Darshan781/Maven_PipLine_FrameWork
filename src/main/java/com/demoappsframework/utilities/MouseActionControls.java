package com.demoappsframework.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;

public class MouseActionControls extends BaseUtility {
	
	private Actions action;
	
	private static Logger log = LoggerUtility.getLogger(MouseActionControls.class);
	
	public MouseActionControls(WebDriver driver) {
		super(driver);
		action = new Actions(driver);		
	}
    
	public void doRightClickOnElement(WebElement element) {
		try {
			action.contextClick(element).perform();
		} catch (Exception e) {
			log.info("Performing right click action errro");
			throw new ApplicationExceptions(ApplicationConstants.doRightClickOnElementErrorMsg);
		}
	}
	
	public void doClickOnElement(WebElement element) {
		try {
			action.click(element).perform();
		} catch (Exception e) {
			log.info("Performing left click action error");
			throw new ApplicationExceptions(ApplicationConstants.doClickOnElementErrorMsg);
		}
	}
	
	public void doDoubleClickOnElement(WebElement element) {
		try {
			action.doubleClick(element).perform();
		} catch (Exception e) {
			log.info("Performing double click action error");
			throw new ApplicationExceptions(ApplicationConstants.doDoubleClickOnElementErrorMsg);
		}
	}
	
	public void dragAndDropElement(WebElement src, WebElement dst ) {
		try {
			action.dragAndDrop(src, dst).perform();
		} catch (Exception e) { 
			log.info("Performing drag and drag action error");
			throw new ApplicationExceptions(ApplicationConstants.dragAndDropElementErrorMsg);
		}
	}
	
	public void scrollUpOrDown(int x, int y) {
		try {
			action.scrollByAmount(x, y).perform();
		} catch (Exception e) {
			log.info("Performing scroll Action error");
			throw new ApplicationExceptions(ApplicationConstants.scrollUpOrDownErrorMsg);
		}
	}
	
	public void scrollToElement(WebElement element) {
		try {
			action.scrollToElement(element).perform();
		} catch (Exception e) {
			log.info("Performing scroll to element action error");
			throw new ApplicationExceptions(ApplicationConstants.scrollToElementErrorMsg);
		}
	}
}
