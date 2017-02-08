package com.oneTrust.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneTrustHomePage {
	
	@FindBy(linkText = "Contact")
	WebElement contact;
	
	public void navigateToContact(){
		contact.click();
		System.out.println("contact navigation success");
	}
	

}
