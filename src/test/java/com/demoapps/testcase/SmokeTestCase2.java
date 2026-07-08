package com.demoapps.testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.demoapps.testBase.BaseTest;

public class SmokeTestCase2 extends BaseTest {

	
	@Test
	public void smokeTC_01() {
	boolean flag = welcomePage.checkRegisterLinkIsEnabled();
	Assert.assertTrue(flag);	
	//Assert.fail();
		
}
	@Test
    public void smokeTC_02() {
    boolean flag = welcomePage.checkLoginLinkIsEnabled();
	Assert.assertTrue(flag);
}
    
	@Test
    public void smokeTC_03() {
    boolean flag = welcomePage.checkCartLinkIsEnabled();
	//Assert.assertTrue(flag);
}   
	@Test
    public void smokeTC_04() {
    boolean flag = welcomePage.checkWhishlistLinkIsEnabled();
	Assert.assertTrue(flag);
}    
	
	@Test
    public void smokeTC_06() {
    boolean flag = welcomePage.checkSearchFieldEnabled();
	Assert.assertTrue(flag);
	}
	
	@Test
	public void smokeTc_07() {
	welcomePage.verifyTitleRegisterLink();
	String expectedTitle = welcomePage.checkRegisterPage();
	String actualTitle = browserControls.fetchPageTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	Reporter.log("Page Title: " + actualTitle, true);
	}
	
	
	    @Test
	    public void verifyTitleOfApparelAndShoes() {
		//welcomePage.apparelAndShoesLinkIsEnabled();
		String expectedTitle = welcomePage.apparelAndShoesLinkIsEnabled();
		String actualTitle = browserControls.fetchPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Page Title: " + actualTitle, true);
	}
		
	    @Test
		public void verifyTitleOfJewelryPage() {
		//welcomePage.checkJewelryPage();
		String expectedTitle1 = welcomePage.checkJewelryPage();
		String actualTitle1 = browserControls.fetchPageTitle();
		Assert.assertEquals(actualTitle1, expectedTitle1);
		Reporter.log("Page Title: " + actualTitle1, true);
		}
	
		@Test
		public void verifyTitleOfElectronicsPage() {
		//welcomePage.electronicsLinkIsEnabled();
		String expectedTitle2 = welcomePage.electronicsLinkIsEnabled();
		String actualTitle2 = browserControls.fetchPageTitle();
		Assert.assertEquals(actualTitle2, expectedTitle2);
		Reporter.log("Page Title: " + actualTitle2, true);
		}
		
		@Test
		public void verifyTitleOfBookPage() {
		//welcomePage.checkBookLinkIsEnabled();
		String expectedTitle3 = welcomePage.checkBookLinkIsEnabled();
		String actualTitle3 = browserControls.fetchPageTitle();
		Assert.assertEquals(actualTitle3, expectedTitle3);
		Reporter.log("Page Title: " + actualTitle3, true);
		
	}
	
	
}

