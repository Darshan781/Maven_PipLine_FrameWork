package com.demoappsframwork.PageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    
	private final By logoutLink = By.xpath("//a[.='Log out']");
	
    public UserPage(WebDriver driver) {
	super(driver);
	}

	public WelcomePage doLogout() {
		elementControls.clickOnElement(fluentWait.locateElement(logoutLink));
		return new WelcomePage(driver);
	}
	
}
