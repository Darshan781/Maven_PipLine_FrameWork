package com.demoappsframework.utilities;

import java.io.FileInputStream;

import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;

public class ReadExcelData {
	
	private static Logger log = LoggerUtility.getLogger(ReadExcelData.class);
	
	public String readData(String excelPath, String sheetName, int rowNumber, int cellNumber) {
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNumber);
			XSSFCell cell = row.getCell(cellNumber);
			return cell.getStringCellValue();
		}   catch (Exception e) {
			log.info(ApplicationConstants.readDataFromExcelErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.readDataFromExcelErrorMsg);		
		}
		
	}

    public int getLastRowN(String excelPath, String sheetName) {
    	try {
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet(sheetName);
			return sheet.getLastRowNum();
    	}   catch (Exception e) {
    		log.info(ApplicationConstants.failedToReturnLastRowErrorMsglog);
			throw new ApplicationExceptions(ApplicationConstants.failedToReturnLastRowErrorMsg);		
		}
		
	
    	
    }
}
