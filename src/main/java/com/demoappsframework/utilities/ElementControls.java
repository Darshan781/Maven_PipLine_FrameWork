package com.demoappsframework.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;
import com.demoappsframework.Helper.ValidationHelper;

public class ElementControls extends BaseUtility {
	
	private static Logger log = LoggerUtility.getLogger(ElementControls.class);
	
	public ElementControls(WebDriver driver) {
		super(driver);
	}

	public void clickOnElement(WebElement element) {
		ValidationHelper.validateElement(element, "clickOnElement()");
		try {
			element.click();
		} catch (Exception e) {
			log.info(ApplicationConstants.clickOnElementErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.clickOnElementErrorMsg+element);
		}
	}
	
	public void clearValues(WebElement element) {
		ValidationHelper.validateElement(element, "clearValues()");
		try {
			element.clear();
		} catch (Exception e) {
			log.info(ApplicationConstants.clearValuesErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.clearValuesErrorMsg+element);
		}
	}
	
	public void enterValues(WebElement element, String value) {
		ValidationHelper.validateElement(element, "enterValues()");
		try {
			clearValues(element);
			element.sendKeys(value);
		} catch (Exception e) {
			log.info(ApplicationConstants.enterValuesErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.enterValuesErrorMsg+"+element+"+value);
		}
	}
	
	public void submitValues(WebElement element) {
		ValidationHelper.validateElement(element, "submitValues()");
		try {
			element.submit();
		} catch (Exception e) {
			throw new ApplicationExceptions(ApplicationConstants.submitValuesErrorMsg+element);
		}
	}
	
	public String fetchElementAttribute(WebElement element, String attributeName) {
		ValidationHelper.validateElement(element, "fetchElementAttribute()");
		ValidationHelper.validateStringInput(attributeName, "fetchElementAttribute()");
		try {
			return element.getAttribute(attributeName);
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementAttributeErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementAttributeErrorMsg+element+""+attributeName);
		}
	}
	
	public String fetchElementCssValue(WebElement element, String cssKey) {
		ValidationHelper.validateElement(element, "fetchElementCssValue()");
		ValidationHelper.validateStringInput(cssKey, "fetchElementCssValue()");
		try {
			return element.getAttribute(cssKey);
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementCssValueErrorMsglog);
		   throw new ApplicationExceptions(ApplicationConstants.fetchElementCssValueErrorMsg+element);
		}
	}
	
	public String fetchElementText(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementText()");
		try {
			return element.getText();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementTextErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementTextErrorMsg+element);
		}
	}
	
	public String fetchElementTagName(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementTagName()");
		try {
			return element.getTagName();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementTagNameErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementTagNameErrorMsg+element);
		}
	}
	
	public String fetchElementRole(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementRole()");
		try {
			return element.getAriaRole();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementRoleErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementRoleErrorMsg+element);
		}
	}
	
	public String fetchElementAccessiableName(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementAccessiableName()");
		try {
			return element.getAccessibleName();	
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementAccessiableNameErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementAccessiableNameErrorMsg+element);
		}
	}
	
	public int fetchElementHeight(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementHeight()");
		try {
			return element.getRect().getHeight();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementHeightErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementHeightErrorMsg+element);
		}
				
	}
	
	public int fetchElementWidth(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementWidth()");
		try {
			return element.getRect().getWidth();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementWidthErrorMsglog);
		   throw new ApplicationExceptions(ApplicationConstants.fetchElementWidthErrorMsg+element);
		}
	}
	
	public int fetchElementX(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementX()");
		try {
			return element.getRect().getX();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchElementXDErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementXDErrorMsg+element);
		}
	}
	
	public int fetchElementY(WebElement element) {
		ValidationHelper.validateElement(element, "fetchElementY()");
		try {
			return element.getRect().getY();
		} catch (Exception e) {
				log.info(ApplicationConstants.fetchElementYErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchElementYErrorMsg+element);
		}
	}
	
	public boolean checkElementIsDisplayed(WebElement element) {
		ValidationHelper.validateElement(element, "checkElementIsDisplayed()");
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			log.info(ApplicationConstants.checkElementIsDisplayedErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkElementIsDisplayedErrorMsg);
		}
	}
	
	public boolean checkElementIsEnabled(WebElement element) {
		ValidationHelper.validateElement(element, "checkElementIsEnabled()");
		try {
			return element.isEnabled();
		} catch (Exception e) {
			log.info(ApplicationConstants.checkElementIsEnabledErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkElementIsEnabledErrorMsg);
		}
	}
	
	public boolean checkElementIsSelected(WebElement element) {
		ValidationHelper.validateElement(element, "checkElementIsSelected()");
		try {
			return element.isSelected();
		} catch (Exception e) {
			log.info(ApplicationConstants.checkElementIsSelectedErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkElementIsSelectedErrorMsg);
		}
	}
	
	
}
