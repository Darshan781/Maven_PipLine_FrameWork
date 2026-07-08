package com.demoapps.TestData;

import org.testng.annotations.DataProvider;

import com.demoapps.FrameWorkConstants.PathConstants;
import com.demoappsframework.utilities.ReadExcelData;

public class TestDataProvider {
	

	ReadExcelData readExcelData = new ReadExcelData();
	
	@DataProvider(name = "productsList")
	public Object[][]  productTestData() {		
	int lastRow = readExcelData.getLastRowN(PathConstants.excelFilePath,"AddToCartProductsList");
	Object [][] productData = new Object [lastRow+1][2];
	for (int r = 0; r <=lastRow; r++) {
		productData[r][0] = readExcelData.readData(PathConstants.excelFilePath, "AddToCartProductsList", r, 0);
		productData[r][1] = r+1;		
	}
	return productData;
	}
	
	@DataProvider (name = "userRegData")
	public String[][] registerData() {
	String [][] regData = new String [1][5];
	regData [0][0] = DynamicDataGenerator.getFirstName();
	regData [0][1] = DynamicDataGenerator.getLastName();
	regData [0][2] = DynamicDataGenerator.getEmailId();
	regData [0][3] = DynamicDataGenerator.getPassword();
	regData [0][4] = DynamicDataGenerator.getGender();
	return regData;
}

}
