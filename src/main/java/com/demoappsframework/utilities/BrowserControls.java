package com.demoappsframework.utilities;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;
import com.demoappsframework.Helper.ValidationHelper;

public class BrowserControls extends BaseUtility {
	
	private static Logger log = LoggerUtility.getLogger(BrowserControls.class);
	
		public BrowserControls(WebDriver driver) {
			super(driver);
		}
		
	public void enterUrl(String testUrl) {
		ValidationHelper.validateStringInput(testUrl, "enterUrl()");
		try {
			driver.get(testUrl);			
		} catch (Exception e) {
			log.info(ApplicationConstants.enterUrlErrorMsglog);
			Reporter.log("The entered testurl is "+testUrl,true);
			throw new ApplicationExceptions(ApplicationConstants.enterUrlErrorMsg);
		}
	}
	
	public String fetchPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			Reporter.log("Title of the page is "+fetchPageTitle(),true);
			log.info(ApplicationConstants.fetchPageTitleErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchPageTitleErrorMsg);
		}
	}
	
	public String fetchPageUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			Reporter.log("PageUrl is "+fetchPageUrl(),true);
			log.info(ApplicationConstants.fetchPageUrlErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchPageUrlErrorMsg);
		}
	}
	
	public String fetchPageSource() {
		try {
			return driver.getPageSource();		
		} catch (Exception e) {
			Reporter.log("PageSource is "+fetchPageSource(),true);
			log.info(ApplicationConstants.fetchPageSourceErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchPageSourceErrorMsg);
		}
	}
	
	public void maxmizeBrowser() {
		try {
		 driver.manage().window().maximize();
		} catch (Exception e) {
			log.info(ApplicationConstants.maxmizeBrowserErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.maxmizeBrowserErrorMsg);
		}
	}
	
    public void minimizeBrowser() {
    	try {
    		driver.manage().window().minimize();
		} catch (Exception e) {
			log.info(ApplicationConstants.minimizeBrowserErrorMsglog);
		throw new ApplicationExceptions(ApplicationConstants.minimizeBrowserErrorMsg);
		}
	}

    public void fullscreenBrowser() {
    	try {
    		driver.manage().window().fullscreen();
		} catch (Exception e) {
			log.info(ApplicationConstants.fullscreenBrowserErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fullscreenBrowserErrorMsg);
		}
	}
    
    public void navigateToPage(String testUrl) {
    	ValidationHelper.validateStringInput(testUrl, "navigateToPage()");
    	try {
    		driver.navigate().to(testUrl);
		} catch (Exception e) {
			log.info(ApplicationConstants.navigateToPageErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.navigateToPageErrorMsg);
		}
    }
    
    public void navigateToPreviousPage() {
    	try {
    		driver.navigate().back();
		} catch (Exception e) {
			log.info(ApplicationConstants.navigateToPreviousPageErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.navigateToPreviousPageErrorMsg);
		}
	}
    
    public void navigateToForwardPage() {
    	try {
    		driver.navigate().forward();
		} catch (Exception e) {
			log.info(ApplicationConstants.navigateToForwardPageErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.navigateToForwardPageErrorMsg);
		}
    }
    
    public void reloadPage() {
    	try {
    		driver.navigate().refresh();
		} catch (Exception e) {
			log.info(ApplicationConstants.reloadPageErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.reloadPageErrorMsg);
		}
     }
    
    public WebElement locateElement(By locators) {
    	ValidationHelper.validateLocators(locators, "locateElement()");
    	try {
    		return	driver.findElement(locators);
		} catch (Exception e) {
			log.info(ApplicationConstants.locateElementErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.locateElementErrorMsg);
		}
    }
    
    public List<WebElement> locateMultipleElement(By locators) {
    	ValidationHelper.validateLocators(locators, "locateElement()");
    	try {
    		 return	driver.findElements(locators);		
		} catch (Exception e) {
			log.info(ApplicationConstants.locateMultipleElementErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.locateMultipleElementErrorMsg);
		}
   }
    
    public String fetchParentTabAddress() {
    	try {
    		return driver.getWindowHandle();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchParentTabAddressErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchPageUrlErrorMsg);
		}
    }
    
    public Set<String> fetchAllTabAddress() {
    	try {
    		return	driver.getWindowHandles();
		} catch (Exception e) {
			log.info(ApplicationConstants.fetchAllTabAddressErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.fetchAllTabAddressErrorMsg);
		}
    }
    
//    public WebDriver handleFrames(Object input) { //integer/id/address
//    	try {
//		    if(input instanceof Integer) {
//    		ValidationHelper.validateIntegerInput((Integer)input, "handleFrames()");
//    		driver.switchTo().frame((Integer)input);
//    	}
//    	else if(input instanceof String) {
//    		ValidationHelper.validateStringInput((String)input, "handleFrames()");
//    		driver.switchTo().frame((String)input);
//    	}
//    	else if(input instanceof WebElement) {
//    		ValidationHelper.validateElement((WebElement)input, "handleFrames()");
//    		driver.switchTo().frame((WebElement)input);
//    	}
//    	return driver;
//    	}
//    	catch (Exception e) {
//			throw new ApplicationExceptions("Failed to switch to Frames-[BrowserControls]->handleFrames()");
//		}
//	}
    
    public WebDriver handleFrames(Integer input) {
    	ValidationHelper.validateIntegerInput(input, "handleFrames()");
    	try {
    		 return	driver.switchTo().frame(input);	
		} catch (Exception e) {
			log.info(ApplicationConstants.handleFramesIntegerInputErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.handleFramesIntegerInputErrorMsg);
		}
   	}
    
    public WebDriver handleFrames(String input) {
    	ValidationHelper.validateStringInput(input, "handleFrames()");
    	try {			
		 return	driver.switchTo().frame(input);	
   		} catch (Exception e) {
   			log.info(ApplicationConstants.handleFramesStringInputErrorMsglog);
   			throw new ApplicationExceptions(ApplicationConstants.handleFramesStringInputErrorMsg);
   		}
    }
       
    public WebDriver handleFrames(WebElement input) {
    	ValidationHelper.validateElement(input, "handleFrames()");
    	try {			
   		 return	driver.switchTo().frame(input);	
      		} catch (Exception e) {
      			log.info(ApplicationConstants.handleFramesWebelemtInputErrorMsglog);
      			throw new ApplicationExceptions(ApplicationConstants.handleFramesWebelemtInputErrorMsg);
      		}
        }
    
    public WebDriver handleWindows(String tabAddress) {
    	ValidationHelper.validateStringInput(tabAddress, "handleWindows()");
    	try {
    		return driver.switchTo().window(tabAddress);
		} catch (Exception e) {
				log.info(ApplicationConstants.handleWindowsErrorMsglog);
		throw new ApplicationExceptions(ApplicationConstants.handleWindowsErrorMsg);
		}
   }
    
    public Alert handleAlertPopups() {
    	try {
    		return	driver.switchTo().alert();
		} catch (Exception e) {
			log.info(ApplicationConstants.handleAlertPopupsErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.handleAlertPopupsErrorMsg);
		}
	}
    
    public void closeTab() {
    	try {
    		driver.close();	
		} catch (Exception e) {
			log.info(ApplicationConstants.closeTabErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.closeTabErrorMsg);
		}
    }
    
    public void terminateBrowser() {
    	try {
    		driver.quit();	
		} catch (Exception e) {
			log.info(ApplicationConstants.terminateBrowserErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.terminateBrowserErrorMsg);
		}
    }
}
