package com.demoapps.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoapps.TestData.TestDataProvider;
import com.demoapps.testBase.BaseTest;
import com.demoappsframwork.PageLayers.RegisterPage;
import com.demoappsframwork.PageLayers.UserPage;

public class FuncationalTestCase extends BaseTest {
	 UserPage userPage;
	 RegisterPage registerPage;
	 	 
	 
//	 @BeforeMethod
//	 public void getInToRegisterPage() {
//		 
//		
//	}
//	 
	 @Test(dataProvider = "userRegData",dataProviderClass = TestDataProvider.class)
	    public void FC_01userRegistrationPage(String name,String lname,String email,String pwd,String gender) {
		 registerPage =	welcomePage.clickOnRegisterLink();
	     userPage =  registerPage.doRegister(name, lname, email, pwd, gender);
	     //Assert.fail();
		 userPage.doLogout();
		 welcomePage.clickOnRegisterLink();
		}
}
