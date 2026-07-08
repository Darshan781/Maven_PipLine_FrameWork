package com.demoapps.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoapps.TestData.TestDataProvider;
import com.demoapps.testBase.BaseTest;


public class IntegrationTestCase extends BaseTest {
//	@Test
//	public void iTC_01() {
//	String productTitle	= welcomePage.searchProduct("Fiction");
//		Reporter.log("The product title is \t"+productTitle,true);
//		Assert.assertEquals(productTitle, "Fiction"); 
//	}
//    @Test
//    public void iTC_02() {
//		String productTitle = welcomePage.addToCartAndVerify("Health Book");
//		Reporter.log("The product title is\t"+productTitle,true);
//		Assert.assertEquals(productTitle, "Health Book");
//	}
//      @Test
//    public void iTC_03() {
//    	String actualTitle = welcomePage.checkApparelAndShoesPage();
//		String expectedTitle = browserControls.fetchPageTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
//		Reporter.log("Page Title: " + actualTitle, true);
//}
//      @Test
//    public void iTC_04() {
//    	String actualTitle = welcomePage.checkJewelryPage();
//		String expectedTitle = browserControls.fetchPageTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
//		Reporter.log("Page Title: " + actualTitle, true);
//	
//}
//      @Test
//    public void iTC_05() {
//    	String actualTitle = welcomePage.checkElectronicsPage();
//		String expectedTitle = browserControls.fetchPageTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
//		Reporter.log("Page Title: " + actualTitle, true);
//}
      
      @Test(dataProvider = "productsList", dataProviderClass = TestDataProvider.class)
      public void iTC_06VerifyMultipleCartProducts(String productsNameInExcel, int index) {
    	String productTitleInCart = welcomePage.verifyMultipleProductsCart(productsNameInExcel, index);
    	Assert.assertEquals(productTitleInCart, productsNameInExcel);
    	//Assert.fail();
    }
}
