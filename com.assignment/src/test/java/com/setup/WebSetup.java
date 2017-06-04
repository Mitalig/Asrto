package com.setup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;


public class WebSetup {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public static Date date = new Date();
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

	public static void setBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Chrome")) {

			if (System.getProperty("os.name").contains("Mac")) {

				System.setProperty("webdriver.chrome.driver", "resources/Log4jConfiguration/MacOs/chromedriver");

			} else {

				System.setProperty("webdriver.chrome.driver", "resources/Log4jConfiguration/Windows/chromedriver.exe");

			}

			WebDriver driver = new WebDriverFactory().create(browser);
			driver.manage().window().maximize();

			setWebDriver(driver);

		}

	}

	public static void setWebDriver(WebDriver driver) {

		dr.set(driver);

	}

	public static WebDriver getDriver() {

		return dr.get();

	}

	public static void shutBrowser(String browser) throws IOException {

		WebDriver driver = getDriver();

		GenericMethods.waitFor(5000);

		driver.quit();

	}

}
