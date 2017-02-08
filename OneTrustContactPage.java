package com.oneTrust.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneTrust.utility.ExcelUtil;

public class OneTrustContactPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-1")
	WebElement contactName;
	
	@FindBy(id = "input-2")
	WebElement contactLastName;
	
	@FindBy(id = "input-3")
	WebElement contactEmail;
	
	@FindBy(id = "input-5")
	WebElement contactComapany;
	
	@FindBy(id = "input-4")
	WebElement contactPhone;
	
	@FindBy(id = "00N3600000LNxBv")
	WebElement contactComment;
	
	public OneTrustContactPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	public void enterContactCredentials(){	
		try {
			String firstName = ExcelUtil.getCellData(1, 1); 
			String lastName = ExcelUtil.getCellData(1, 2);
			String email = ExcelUtil.getCellData(1,3);
			String company = ExcelUtil.getCellData(1,4);
			String phone = ExcelUtil.getCellData(1,5);
			String comment = ExcelUtil.getCellData(1,6);
			
			contactName.sendKeys(firstName);
			contactLastName.sendKeys(lastName);
			contactEmail.sendKeys(email);
			contactComapany.sendKeys(company);
			contactPhone.sendKeys(phone);
			contactComment.sendKeys(comment);
            System.out.println("all the contact data entereds");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public void contactScreenShot(){
			try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\OneTrustContact.png"));
			System.out.println("contact screen shot saved successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
