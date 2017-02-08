package com.oneTrust.page.test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.oneTrust.pages.OneTrustContactPage;
import com.oneTrust.pages.OneTrustHomePage;
import com.oneTrust.utility.ExcelUtil;
import com.oneTrust.utility.OneTrustContactData;

public class OneTrustTest {
	
	WebDriver driver;
	
	OneTrustHomePage homePage;
	OneTrustContactPage contactPage;
	
	@Test
	public void contactTest(){
		try {	
			ExcelUtil.setExcelFile(OneTrustContactData.TestData_path + OneTrustContactData.TestData_File, "TestData");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(OneTrustContactData.URL);
			homePage.navigateToContact();
			contactPage.enterContactCredentials();
			contactPage.contactScreenShot();
			 driver.quit(); 
		        //This is to send the PASS value to the Excel sheet in the result column.
		        ExcelUtil.setCellData("Pass", 1, 7);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
 
	
}
