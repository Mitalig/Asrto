package com.setup;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class GenericMethods {

	public static long start;
	public static long stop;
	static Response resp;

	public static void navigate(WebDriver driver, String url) {

		driver.navigate().to(url);
	}

	public static void startWatch() {

		start = System.currentTimeMillis();
	}

	public static int stopWatch() {

		stop = System.currentTimeMillis();

		long pageLoadTime = stop - start;

		return (int) (pageLoadTime / 1000);
	}

	public static boolean assertElementPresent(WebDriver driver, String sLocators) {

		try {

			waitMethod(driver, sLocators);

			Boolean isPresent = driver.findElements(By.xpath(sLocators)).size() > 0;

			if (isPresent) {
				return true;

			} else {
				return false;

			}
		} catch (Exception e) {
			System.out.println("The element is not present " + e.getMessage());
		}

		return false;
	}

	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static void click(WebDriver driver, String sLocator) {

		waitToClickMethod(driver, sLocator);

		driver.findElement(By.xpath(sLocator)).click();

	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static void doubleClick(WebDriver driver, String sLocator, String locatorType) {

		waitToClickMethod(driver, sLocator);

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.xpath(sLocator));
		action.doubleClick(element).build().perform();

	}

	public static void selectFromDropdown(WebDriver driver, String sLocator, String locatorType, String sValue) {

		waitMethod(driver, sLocator);

		Select oSelect = new Select(driver.findElement(By.xpath(sLocator)));
		oSelect.selectByValue(sValue);

	}

	public static Alert getAlert(WebDriver driver) {

		Alert alt = driver.switchTo().alert();
		return alt;

	}

	public static String getText(WebDriver driver, String sLocator) {

		waitMethod(driver, sLocator);

		return driver.findElement(By.xpath(sLocator)).getText();

	}

	public static void input(WebDriver driver, String sLocator,String inputValue) {

		waitMethod(driver, sLocator);


			driver.findElement(By.xpath(sLocator)).sendKeys(inputValue);

		
	}

	public static void waitMethod(WebDriver driver, String sLocators) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));

	}

	public static void waitAlertPresent(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void scrollDown(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public static void switchToWindow(WebDriver driver) {

		String handle = driver.getWindowHandle();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		tabs.remove(handle);
		waitFor(3000);
		driver.switchTo().window(tabs.get(0));
	}

	public static void waitFor(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void waitForPageLoad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public static void waitToClickMethod(WebDriver driver, String sLocators) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));

	}

	public static int isLinkBroken(URL url) throws Exception {

		resp = given().

				contentType(ContentType.JSON).

				when().

				get(url);

		// Assert.assertEquals(resp.getStatusCode(), 200);

		return resp.getStatusCode();

	}

	public static int getResponseTime() {

		// Assert.assertEquals(resp.getStatusCode(), 200);

		return (int) resp.getTime();

	}

}