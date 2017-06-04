package com.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.setup.ConstantLocators;
import com.setup.GenericMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationPage {

	
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToLoginPage(String url) {
	   
		GenericMethods.navigate(driver, url);
	}
	
	
    public  void verifySignup()  {
		   
			GenericMethods.waitAlertPresent(driver);
		Alert alt=GenericMethods.getAlert(driver);
		Assert.assertEquals(alt.getText(), "Enter the Correct Policy No");
		alt.accept();    
		}
		//return new RegistrationPage(driver);
		     
		     
    }
    
  

