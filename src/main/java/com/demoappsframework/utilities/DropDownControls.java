package com.demoappsframework.utilities;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;

public class DropDownControls {
	
	private static Logger log = LoggerUtility.getLogger(DropDownControls.class);
	
	    private  Select s;
	    public DropDownControls(WebElement element) {
		 s = new Select(element);		
	}
	
	public void selectSingleSelectDropDown(Select s, Object value) {
		if(!s.isMultiple()) {
			if(value instanceof Integer) {
			s.selectByIndex((int)value);
			}else if(value instanceof String) {
			s.selectByValue((String)value);
			}else if(value instanceof String) {
			s.selectByVisibleText((String)value);
			}else if(value instanceof String) {
			s.selectByContainsVisibleText((String)value);
				}
			else {
			    log.info(ApplicationConstants.selectSingleSelectDropDownErrorMsglog);
				throw new ApplicationExceptions(ApplicationConstants.selectSingleSelectDropDownErrorMsg);
			}
		}
		else {
			 log.info(ApplicationConstants.selectSingleSelectDropDown1ErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.selectSingleSelectDropDown1ErrorMsg);
		}
	}
	
	public void selectMultipleSelectDropDown(Select s, Object value) {
		if(s.isMultiple()) {
			if(value instanceof Integer) {
			s.selectByIndex((int)value);
			}else if(value instanceof String) {
			s.selectByValue((String)value);
			}else if(value instanceof String) {
			s.selectByVisibleText((String)value);
			}else if(value instanceof String) {
			s.selectByContainsVisibleText((String)value);
				}
			else {
				log.info(ApplicationConstants.selectMultipleSelectDropDownErrorMsglog);
				throw new ApplicationExceptions(ApplicationConstants.selectMultipleSelectDropDownErrorMsg);
			}
		}
		else {
			log.info(ApplicationConstants.selectMultipleSelectDropDown1ErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.selectMultipleSelectDropDown1ErrorMsg);
		}
	}
	
	public void deselectSingleSelectDropDown(Select s, Object value) {
		if(!s.isMultiple()) {
			if(value instanceof Integer) {
			s.deselectByIndex((int)value);
			}else if(value instanceof String) {
			s.deselectByValue((String)value);
			}else if(value instanceof String) {
			s.deselectByVisibleText((String)value);
			}else if(value instanceof String) {
			s.deSelectByContainsVisibleText((String)value);
				}
			else {
				log.info(ApplicationConstants.deselectSingleSelectDropDownErrorMsglog);
				throw new ApplicationExceptions(ApplicationConstants.deselectSingleSelectDropDownErrorMsg);
			}
		}
		else {
			log.info(ApplicationConstants.deselectSingleSelectDropDownErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.deselectSingleSelectDropDown1ErrorMsg);
		}
	}
      
	public void deselectMultiSelectDropDown(Select s, Object value) {
		if(s.isMultiple()) {
			if(value instanceof Integer) {
			s.deselectByIndex((int)value);
			}else if(value instanceof String) {
			s.deselectByValue((String)value);
			}else if(value instanceof String) {
			s.deselectByVisibleText((String)value);
			}else if(value instanceof String) {
			s.deSelectByContainsVisibleText((String)value);
				}
			else {
				log.info(ApplicationConstants.deselectMultiSelectDropDownErrorMsglog);
				throw new ApplicationExceptions(ApplicationConstants.deselectMultiSelectDropDownErrorMsg);
			}
		}
		else {
			log.info(ApplicationConstants.deselectMultiSelectDropDown1ErrorMasglog);
			throw new ApplicationExceptions(ApplicationConstants.deselectMultiSelectDropDown1ErrorMasg);
		}
	}
	
	public void deSelectAllOptionsMultiSelect(Select s) {
		if(s.isMultiple()) {
		s.deselectAll();		
	}
		else {
			log.info(ApplicationConstants.deSelectAllOptionsMultiSelectErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.deSelectAllOptionsMultiSelectErrorMsg);
		}
	}
	
	public void deselectAllOptionsSingleSelect(Select s) {
		if(!s.isMultiple()) {
			s.deselectAll();
		}
		else {
			log.info(ApplicationConstants.deselectAllOptionsSingleSelectErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.deselectAllOptionsSingleSelectErrorMsg);
		}
	}
	
	public List<WebElement> fetchAddressOfAllOptions() {
		try {
			return	s.getOptions();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchAddressOfAllOptionsErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchAddressOfAllOptionsErrorMsg);
		}
	}
	
	public List<WebElement> fetchAddressOfSeletedOptions() {
		try {
			return s.getAllSelectedOptions();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchAddressOfSeletedOptionsErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchAddressOfSeletedOptionsErrorMsg);
		}
	}
	
	public WebElement fethAddressOfFirstSelectedOptions() {
		try {
			return s.getFirstSelectedOption();
		} catch (Exception e) {
			log.info(ApplicationConstants.fethAddressOfFirstSelectedOptionslog);
			throw new ApplicationExceptions(ApplicationConstants.fethAddressOfFirstSelectedOptions);
		}
	}
	
	public void checkIsMultipleOrNot() {
		try {
			s.isMultiple();
		} catch (Exception e) {
			log.info(ApplicationConstants.checkIsMultipleOrNotErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.checkIsMultipleOrNotErrorMsg);
		}
	}
}
