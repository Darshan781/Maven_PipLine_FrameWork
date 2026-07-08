package com.demoappsframework.utilities;

import org.openqa.selenium.WebDriver;

public class BaseUtility {
	 
	protected static WebDriver driver;	
	
	public BaseUtility(WebDriver driver) {
		BaseUtility.driver = driver;
	}
}
