package com.demoappsframework.Helper;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;
import com.demoappsframework.FrameWorkExpections.ElementExceptions;
import com.demoappsframework.utilities.LoggerUtility;

public class ValidationHelper {
	
	private static Logger log = LoggerUtility.getLogger(ValidationHelper.class);
	
	public static void validateStringInput(String Stringinput, String methodName) {
		if(Stringinput == null) {
			log.info(ApplicationConstants.validateStringInputErrorMsglog+Stringinput);
			throw new ElementExceptions(ApplicationConstants.validateStringInputErrorMsg+Stringinput);			
		}
		if(methodName == null) {
			log.info(ApplicationConstants.validateMethodNameErrorMsglog+methodName);
			throw new ApplicationExceptions(ApplicationConstants.validateMethodNameErrorMsg+methodName);
		}		
	}
	
    public static void validateIntegerInput(Integer IntegerInput, String methodName) {
	if(IntegerInput == null) {
		log.info(ApplicationConstants.validateIntegerInputErrorMsglog+IntegerInput);
		throw new ElementExceptions(ApplicationConstants.validateIntegerInputErrorMsg+IntegerInput);		
	}
	if(methodName == null) {
		log.info(ApplicationConstants.validateMethodNameErrorMsglog+methodName);
		throw new ApplicationExceptions(ApplicationConstants.validateMethodNameErrorMsg+methodName);
	}
	}
		
	public static void validateLocators(By locators, String methodName) {
		if(locators == null) {
			log.info(ApplicationConstants.validateElementErrorMsglog+locators);
			throw new ElementExceptions(ApplicationConstants.validateLocatersErrorMsg+locators);
		}
		if(methodName == null) {
			log.info(ApplicationConstants.validateMethodNameErrorMsglog+methodName);
			throw new ApplicationExceptions(ApplicationConstants.validateMethodNameErrorMsg+methodName);
		}
	}
	
	public static void validateElement(WebElement element, String methodName) {
		if(element == null) {
			log.info(ApplicationConstants.validateElementErrorMsglog+element);
			throw new ElementExceptions(ApplicationConstants.validateElementErrorMsg+element);
		}
		if(methodName == null) {
			log.info(ApplicationConstants.validateMethodNameErrorMsglog+methodName);
			throw new ApplicationExceptions(ApplicationConstants.validateMethodNameErrorMsg+methodName);
		}
}
}
