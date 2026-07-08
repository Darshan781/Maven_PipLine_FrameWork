package com.demoappsframework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;

public class ReadConfigData {

	private Properties prop;
    private static Logger log = LoggerUtility.getLogger(ReadConfigData.class);
	
	public ReadConfigData(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			log.info(ApplicationConstants.invalidFilePathErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.invalidFilePathErrorMsg);

		}
	}

	public String readValue(String key) {
		try {
			return prop.getProperty(key);
		} catch (Exception e) {
			log.info(ApplicationConstants.failedToReturnPropertyValuelog);
			throw new ApplicationExceptions(ApplicationConstants.failedToReturnPropertyValue);

		}
	}

}
