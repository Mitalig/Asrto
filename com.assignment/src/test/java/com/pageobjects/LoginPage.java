package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.setup.ConstantLocators;
import com.setup.GenericMethods;

public class LoginPage {

	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
   public void navigateToLoginPage(String url) {
		
		GenericMethods.navigate(driver, url);

	}
   
   public void enterLoginDetails(String userName, String password) {
		
		}
   
      public void clickOnLoginButton() {
		
	 }
 
      public void verifyLogin()  {

      }
      
      public void closeApplication()  {
 		 
 		 driver.quit();
 	 
 	 }
   
   
}
