
package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Base.SeleniumHandlers.WebDriverHandler;

public class ChromeDriverOptions {

	public static ChromeDriver getHeadlessBrowser() {
		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		return driver;
	}
}
