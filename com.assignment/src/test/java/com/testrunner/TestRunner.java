package com.testrunner;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.setup.WebSetup;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="Features", format={"pretty","html:target/html/"},glue="com.pagedefinitions")
public class TestRunner extends AbstractTestNGCucumberTests
{
	
   @BeforeClass
   @Parameters({"Browser"})
	public void beforeSetup(String browser ) throws Exception  {
	  
	   WebSetup.setBrowser( browser);
				
	}
   
   @After
   public void capture (Scenario scenario)  {
	   
	   if(scenario.isFailed())  {
		   
		   
	   }
   }
   
   @AfterClass
   @Parameters({"Browser"})

   public void shutDown(String browser) throws IOException  {
     
     WebSetup.shutBrowser (browser);
     
   }
   
	
}
