package com.demoapps.configuration;

import com.demoapps.FrameWorkConstants.PathConstants;
import com.demoappsframework.utilities.ReadConfigFile;

public class ConfigurationManager {
	 
	
	private static final ReadConfigFile readConfigFile = new ReadConfigFile(PathConstants.propertyFilePath);
	
	public static String getTestUrl() {
	String	testUrl = System.getProperty("testUrl");
	if(testUrl != null && !testUrl.isBlank()) {
		return testUrl;
	}
	 String testurl = readConfigFile.readValue("testUrl");
	if(testUrl != null && !testUrl.isBlank()) {
		return testUrl;	
	}
	return "https://demowebshop.tricentis.com/";
	}

    public static String getbrowserName(String xmlBrowserName) {
	String	browser = System.getProperty("browser");
	if(browser != null && !browser.isBlank()) {
		return browser;
	}
	if(xmlBrowserName != null && !xmlBrowserName.isBlank()) {
		return xmlBrowserName;
}
	browser = readConfigFile.readValue("browserName");
	if(browser != null && !browser.isBlank()) {
		return browser;	
	}
	return "CHROME";
    }

    public static boolean getheadlessMode(String xmlHeadlessMode) {
    	String headlessMode = System.getProperty("headlessMode");
    	if(headlessMode != null && !headlessMode.isBlank()) {
    		return Boolean.parseBoolean(headlessMode);
    }
    	if(xmlHeadlessMode != null && !xmlHeadlessMode.isBlank()) {
    		return Boolean.parseBoolean(xmlHeadlessMode);
    }
	headlessMode = readConfigFile.readValue("headlessMode");
	if(headlessMode != null && !headlessMode.isBlank()) {
		return Boolean.parseBoolean(headlessMode);
	}
	return false;
 }
    
    public static boolean getprivateMode(String xmlPrivateMode) {
    	String privateMode = System.getProperty("privateMode");
    	if(privateMode != null && !privateMode.isBlank()) {
    		return Boolean.parseBoolean(privateMode);
    }
    	if(xmlPrivateMode != null && !xmlPrivateMode.isBlank()) {
    		return Boolean.parseBoolean(xmlPrivateMode);
    }
	privateMode = readConfigFile.readValue("privateMode");
	if(privateMode != null && !privateMode.isBlank()) {
		return Boolean.parseBoolean(privateMode);
	}
	return false;
}

}
