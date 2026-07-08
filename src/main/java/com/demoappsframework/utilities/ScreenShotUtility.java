package com.demoappsframework.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility  {
	
	public static File getScreenShotFile(WebDriver driver) {
	TakesScreenshot	takeScreenshot = (TakesScreenshot) driver;
		File temp = takeScreenshot.getScreenshotAs(OutputType.FILE);	
		return temp;
	}
	
	public static byte[] getScreenShotBytes(WebDriver driver) {
	TakesScreenshot	takeScreenshot = (TakesScreenshot) driver;
		return takeScreenshot.getScreenshotAs(OutputType.BYTES);		
	}
}
