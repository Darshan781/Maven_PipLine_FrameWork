package com.demoappsframwork.PageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	private By genderChoose;
	
	public By chooseGender(String gender) {
		switch (gender) {
		case "Male": genderChoose = By.id("gender-male");
		break;
		case "Female": genderChoose = By.id("gender-female");
		break;		
		default: Reporter.log("Invaid input");
		}
		return genderChoose;
	}
    	
	private final By firstNameTf = By.id("FirstName");
	private final By lastNameTf = By.id("LastName");
	private final By emailTf = By.id("Email");
	private final By passwordTf = By.id("Password");
	private final By confirmPasswordTf = By.id("ConfirmPassword");
	private final By registerButton = By.id("register-button");
	
//	public void verifyPassword(String password) {
//		elementControls.enterValues(fluentWait.locateElement(passwordTf), password);
//		elementControls.clickOnElement(fluentWait.checkClickable(registerButton));
//	}
	   public UserPage doRegister(String name,String lname,String email,String pwd,String gender) {
		elementControls.enterValues(fluentWait.locateElement(firstNameTf),name);
		elementControls.enterValues(fluentWait.locateElement(lastNameTf),lname);
		elementControls.enterValues(fluentWait.locateElement(emailTf), email);
		elementControls.enterValues(fluentWait.locateElement(passwordTf), pwd);
		elementControls.enterValues(fluentWait.locateElement(confirmPasswordTf), pwd);
		//elementControls.clickOnElement(fluentWait.locateElement(registerButton));
		return new UserPage(driver);
	}

}
