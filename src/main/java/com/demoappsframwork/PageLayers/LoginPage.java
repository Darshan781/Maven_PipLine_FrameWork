package com.demoappsframwork.PageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  extends BasePage{
	private final By emailField = By.id("Email");
	private final By passwordField = By.id("Password");
	private final By loginButton = By.xpath("//input[@type='submit' and @value='Log in']");
	private final By logoutButton = By.xpath("//a[.='Log out']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
    
	public UserPage doLogin(String email, String password) {
	WebElement	emailTf = browserControls.locateElement(emailField);
	elementControls.enterValues(emailTf, email);
	WebElement pwdTf = browserControls.locateElement(passwordField);
	elementControls.enterValues(pwdTf, password);
	elementControls.clickOnElement(fluentWait.locateElement(loginButton));
	return	new UserPage(driver);
	}
	
	public WelcomePage logoutApplication() {
		elementControls.clickOnElement(fluentWait.locateElement(logoutButton));
		return new WelcomePage(driver);
	}
}
