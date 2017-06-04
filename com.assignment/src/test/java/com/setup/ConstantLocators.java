package com.setup;

import java.util.UUID;

public class ConstantLocators {
	public static final String staticFooterText = "//a[contains(@onclick,'About Astro')]";
	public static final String clickHere="//a[text()='click here']";
	public static final String continueToAstro=".//*[@id='continue']";
	public static final String thirdBanner="(.//ol[@class='flex-control-nav flex-control-paging']//a)[3]";
	public static final String registerButton="//div[@id='acmregister']";
	public static final String lastBanner="html/body/form/div[5]/section[1]/ol/li[10]/a";
	public static final String nextButton="//a[@class='flex-next']";

	public static final String thirdBannerText="//div[@class='slidecontent']//h2[text()='Sign Up Today!']";
	public static final String lastBannerText="//li[@class='flex-active-slide']//h2";
	public static final String closeButton="//a[@class='GAEventTrack GAPageView']//em";
	public static final String signUpButton="(//a[@eventaction='Sign Up'])[1]";
	public static final String firstName="//input[@class='form-control txtfirstname txt']";
	public static final String lastName="//input[@class='form-control txtlastname txt']";
	public static final String astroID="//input[@class='form-control txt txtastroid']";
	public static final String emailID="//input[@class='form-control txt txtemail']";
    public static final String password="//input[@id='password']";
    public static final String iAgreeSignUp="//button[@id='btnSubmit']";
    public static final String signUpSuccessful="//div[@class='container']//b";
	public static final String Xpath = "xpath";
	public static final String Css = "css";

}
