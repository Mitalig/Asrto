package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.setup.ConstantLocators;
import com.setup.GenericMethods;

public class InsurancePlanPage {


	WebDriver driver;

	public InsurancePlanPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	 public void navigateToInsuranePlanPage(String url) {
			
			GenericMethods.navigate(driver, url);

	}
	 
	 public void fillPersonalDetails()  {
		 
		

	 }
	 
	 public void choosePlan()  {
		 
		
	 }
	
	 public void fillProposalForm()  {
		 
	     GenericMethods.waitFor(10000);
		
		
	 }
	 
	 public void closeApplication()  {
		 
		 driver.quit();
	 
	 }
}
