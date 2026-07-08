package com.demoappsframework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;

public class ReadConfigFile {

	protected Properties prop;
	
	private static Logger log = LoggerUtility.getLogger(ReadConfigFile.class);

	public ReadConfigFile(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
		}   catch (Exception e) {
			log.info(ApplicationConstants.invalidFilePathErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.invalidFilePathErrorMsg);
		}
	}

	public String readValue(String key) {
		try {
			return prop.getProperty(key);
		} catch (Exception e) {
			log.info(ApplicationConstants.failedToReturnLastRowErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.failedToReturnPropertyValue);
		}
	}

//	public String readFile(String key) {
//		try {
//			return prop.getProperty(key);
//		} catch (Exception e) {
//			throw new ApplicationExceptions(ApplicationConstants.failedToReturnPropertyValue);
//		}
//	}
}