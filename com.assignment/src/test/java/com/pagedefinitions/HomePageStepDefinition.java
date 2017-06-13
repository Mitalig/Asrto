package com.pagedefinitions;

import java.util.List;

import com.pageobjects.HomePage;
import com.setup.ConstantLocators;
import com.setup.GenericMethods;
import com.setup.WebSetup;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class HomePageStepDefinition extends WebSetup {
  
  HomePage hp;
  
  @When("^You navigate to main \"([^\"]*)\"$")
  public void you_navigate_to_main(String url) {
    
	  hp = new HomePage(getDriver()	);
	  GenericMethods.startWatch();
	  hp.navigateToHomePage(url);
	  
  }

  @And("^Click on Third Banner$")
  public void you_click_on_thirdbanner()  {
     hp.clickOnThirdBanner();
  }
  
  @And("^Click on Register Button$")
  public void you_click_on_registerButton()  {
     hp.clickOnRegisterButton();
  }
  
  @And("^Click on Last Banner$")
  public void you_click_on_lastbanner()  {
     hp.clickOnLastBanner();
  }
  
  @And("^Click on Sign up button$")
  public void you_click_on_signupbutton()  {
    hp.clickOnSignUpButton();
  }
  
  @And("^Click on I agree Signup button$")
  public void you_click_on_agreesignupbutton()  {
    hp.clickOnIAgreeSignUpButton();
    
  }
  
  @Then("^Check SignUp is Successful$")
  public void you_click_on_signUpSuccessful()  {
    hp.checkSignUpSuccessful();
    
  }
  
  @And("^Enter the details$")
  public void you_enterthedetails(DataTable table)  {

	  List<List<String>> details =table.raw();
	  
	  hp.enterTheDetails(details);
	  
  }

  @Then("^Check whether page is loaded within (\\d+) second$")
  public void check_whether_page_is_loaded_within_seconds(int seconds)  {
      hp.checkPageisLoaded(seconds);
  }

  @Then("^Check whether it is a desired banner$")
  public void check_whether_it_is_desiredbanner() throws Throwable {
     hp.checkWhetherDesiredBanner();
  }
  
  @Then("^Check whether it is not third banner$")
  public void check_whether_it_is_notlastbanner() throws Throwable {
     hp.checkLastBanner();
  }
  
  @Then("^Check whether page loads without any error$")
  public void check_whether_page_loaded_without_error()  {
      hp.checkPageLoadedWithoutError();
  }

  @Then("^Check whether links are not broken$")
  public void check_whether_links_are_not_broken()  {
     hp.verifyBrokenLinks();
  }
  
 

}
