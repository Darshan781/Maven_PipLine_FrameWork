package com.demoappsframwork.PageLayers;

import org.openqa.selenium.WebDriver;
import com.demoappsframework.utilities.BrowserControls;
import com.demoappsframework.utilities.ElementControls;
import com.demoappsframework.utilities.WaitingStratgey;

public class BasePage {
	protected WebDriver driver;
	protected BrowserControls browserControls;
	protected ElementControls elementControls;
	protected WaitingStratgey fluentWait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		browserControls = new BrowserControls(driver);
		elementControls = new ElementControls(driver);
		fluentWait = new WaitingStratgey(driver);
		
		
	}

}
