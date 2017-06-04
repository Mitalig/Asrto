package com.setup;

import java.awt.Toolkit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {

	static WebDriver create(String browser) throws IllegalAccessException {

		try {
			WebDriver driver;

			switch (browser) {

			case "Chrome":
				ChromeOptions ops = new ChromeOptions();
		        ops.addArguments("--disable-notifications");
		        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        Point position = new Point(0, 0);    
				driver = new ChromeDriver(ops);
				driver.manage().window().setPosition(position);
			    Dimension maximizedScreenSize =
			            new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
			    driver.manage().window().setSize(maximizedScreenSize);
				
				break;

			default:
				throw new IllegalAccessException();

			}

			return driver;
		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;

	}
}
