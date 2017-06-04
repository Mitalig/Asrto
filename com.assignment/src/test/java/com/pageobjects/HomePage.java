package com.pageobjects;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.setup.ConstantLocators;
import com.setup.GenericMethods;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToHomePage(String url) {

		GenericMethods.navigate(driver, url);
		

	}

	public void checkPageisLoaded(int seconds) {

		// GenericMethods.click(driver, ConstantLocators.continueToAstro);
		// GenericMethods.startWatch();

		GenericMethods.waitForPageLoad(driver);
		Assert.assertEquals(GenericMethods.stopWatch(), seconds);

	}
	
	public void clickOnThirdBanner ()  {
		GenericMethods.click(driver, ConstantLocators.thirdBanner);
		System.out.println("Clicked");
	}
	
	public void clickOnRegisterButton()  {
		GenericMethods.click(driver, ConstantLocators.registerButton);
	}
	
	public void clickOnSignUpButton ()  {
		GenericMethods.click(driver, ConstantLocators.signUpButton);
	}
	
	public void clickOnIAgreeSignUpButton ()  {
		GenericMethods.click(driver, ConstantLocators.iAgreeSignUp);
	}
	public void enterTheDetails (List<List<String>> details)  {

		GenericMethods.input(driver, ConstantLocators.firstName, details.get(1).get(0));
		GenericMethods.input(driver, ConstantLocators.lastName, details.get(1).get(1));
		GenericMethods.input(driver, ConstantLocators.astroID, details.get(1).get(2)+UUID.randomUUID().toString());
		GenericMethods.input(driver, ConstantLocators.emailID, details.get(1).get(3)+UUID.randomUUID().toString()+"@gmail.com");
		GenericMethods.input(driver, ConstantLocators.password, details.get(1).get(4));
        GenericMethods.waitFor(6000);
	}
	
	public void clickOnLastBanner () {
		GenericMethods.navigate(driver, "http://www.astro.com.my/");
		for(int i=1;i<=9;i++)  {
		GenericMethods.click(driver, ConstantLocators.nextButton);
		}
	}
	
	public void checkWhetherDesiredBanner () {
		
		Assert.assertEquals(GenericMethods.getText(driver, ConstantLocators.thirdBannerText), "Sign Up Today!");
	}
	
     public void checkLastBanner () {
		
		Assert.assertNotEquals(GenericMethods.getText(driver, ConstantLocators.lastBannerText), "Sign Up Today!");
	}
     
     public void checkSignUpSuccessful () {
 		
 		Assert.assertEquals(GenericMethods.getText(driver, ConstantLocators.signUpSuccessful), "Registration Completed.");
 	}
     public void checkPageLoadedWithoutError () {
  		
  		Assert.assertEquals(GenericMethods.getText(driver, ConstantLocators.staticFooterText), "About Astro");
  	}

	public HomePage verifyBrokenLinks() {

		try {

			//GenericMethods.click(driver, ConstantLocators.continueToAstro);
			GenericMethods.waitMethod(driver, ConstantLocators.staticFooterText);
            GenericMethods.waitFor(5000);
			List<String> hrefs = new ArrayList<String>();
			List<WebElement> anchors = driver.findElements(By.tagName("a"));
			// anchors.addAll(driver.findElements(By.tagName("img")));
			System.out.println("The total links " + anchors.size());

			for (WebElement anchor : anchors) {
				try {

					if (anchor.getAttribute("href") != null)
					hrefs.add(anchor.getAttribute("href"));
				} catch (StaleElementReferenceException e) {
					System.out.println("---------Was Stale----------");
				}
			}

			for (String href : hrefs) {

				try {


					int responseCode = GenericMethods.isLinkBroken(new URL(href));
					if (responseCode != 200) {
						System.out.println("The broken Link is " + href + " and the response time is "
								+ GenericMethods.getResponseTime() +" milliseconds");

					} else {

						System.out.println("The working Link is " + href + " and the response time is "
								+ GenericMethods.getResponseTime()+" milliseconds");

					}
				} catch (Exception e) {
					System.out.println("URL: " + href + " returned " + e.getMessage());

				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

}
