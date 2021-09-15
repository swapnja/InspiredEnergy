
package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitWebElement {

	public static void customWait(By element, WebDriver driver) throws InterruptedException {
		try {
			FluentWait<WebDriver> x = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
			x.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
		}
	}

	public static void waitTillClickable(By element, WebDriver driver) {
		WebElement elementWeb = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
		elementWeb.click();
	}

	public static String waitForVisibility(By element, WebDriver driver) {
		WebElement elementWeb = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(element));
		return elementWeb.getText();
	}

	public static void waitForGreenElement(WebDriver driver) {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("null")));
		} catch (Exception e) {
		}
	}

	public static void performAction(WebDriver driver, By elementBy, WebDriverActionEnum action) {
		switch (action) {
			case Click :
				WebElement element = new WebDriverWait(driver, 5, 100).until(ExpectedConditions.elementToBeClickable(elementBy));
				element.click();
				break;
			case SendKeys :
				break;
			case WaitVisible :
				new WebDriverWait(driver, 5, 100).until(ExpectedConditions.visibilityOf(driver.findElement(elementBy)));
				break;
			case WaitInvisible :
				new WebDriverWait(driver, 5, 100).until(ExpectedConditions.invisibilityOf(driver.findElement(elementBy)));
				break;
			default :
				break;
		}
	}
}
// WebElement w1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
// WebElement w1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]")));
