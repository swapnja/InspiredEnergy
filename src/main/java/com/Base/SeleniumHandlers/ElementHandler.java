
package com.Base.SeleniumHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementHandler {

	private By _by;
	private WebElement _webElement;
	private WebDriver _driver;
	private WebDriverWait _webDriverWait;

	public ElementHandler(WebDriver driver, By by) {
		_driver = driver;
		_by = by;
		//incresed by swapnja
		_webDriverWait = new WebDriverWait(driver, 15, 100);
	}

	public ElementHandler waitPresence() {
		_webElement = _webDriverWait.until(ExpectedConditions.presenceOfElementLocated(_by));
		return this;
	}

	public ElementHandler waitPresence(long timeOutInSeconds, long sleepInMillis) {
		WebDriverWait webDriverWait = new WebDriverWait(_driver, timeOutInSeconds, sleepInMillis);
		_webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(_by));
		return this;
	}

	public ElementHandler waitVisible() {
		waitPresence();
		_webDriverWait.until(ExpectedConditions.visibilityOf(_webElement));
		return this;
	}

	public ElementHandler waitVisible(long timeOutInSeconds, long sleepInMillis) {
		waitPresence();
		WebDriverWait webDriverWait = new WebDriverWait(_driver, timeOutInSeconds, sleepInMillis);
		webDriverWait.until(ExpectedConditions.visibilityOf(_webElement));
		return this;
	}

	public ElementHandler waitInvisible() {
		waitPresence();
		_webDriverWait.until(ExpectedConditions.invisibilityOf(_webElement));
		return this;
	}

	public ElementHandler waitInvisible(long timeOutInSeconds, long sleepInMillis) {
		waitPresence();
		WebDriverWait webDriverWait = new WebDriverWait(_driver, timeOutInSeconds, sleepInMillis);
		webDriverWait.until(ExpectedConditions.invisibilityOf(_webElement));
		return this;
	}

	public ElementHandler waitClickable() {
		waitPresence();
		_webElement = _webDriverWait.until(ExpectedConditions.elementToBeClickable(_by));
		return this;
	}

	public ElementHandler waitClickable(long timeOutInSeconds, long sleepInMillis) {
		waitPresence(timeOutInSeconds, sleepInMillis);
		WebDriverWait webDriverWait = new WebDriverWait(_driver, timeOutInSeconds, sleepInMillis);
		_webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(_webElement));
		return this;
	}

	public ElementHandler click() {
		waitPresence();
		JavascriptExecutor js =(JavascriptExecutor)_driver;
		js.executeScript("arguments[0].click()", _webElement);
		//_webElement.click();
		return this;
	}
	
	/*
	 * public ElementHandler javaScriptclick() { waitPresence(); JavascriptExecutor e = (JavascriptExecutor)_driver; e.executeScript("arguments[0].click();", _webElement); return this; }
	 */

	public ElementHandler sendKeys(CharSequence... keysToSend) {
		waitPresence();
		_webElement.sendKeys(keysToSend);
		return this;
	}

	public ElementHandler selectByValue(String value) {
		waitPresence();
		Select select = new Select(_webElement);
		select.selectByValue(value);
		return this;
	}
	
	public ElementHandler selectByIndex(int index) {
		waitPresence();
		Select select = new Select(_webElement);
		select.selectByIndex(index);
		return this;
	}

	public ElementHandler selectByText(String Text) {
		waitPresence(15,100);
		Select select = new Select(_webElement);
		if(!(Text.equals(""))){
			select.selectByVisibleText(Text);
		}
		return this;
	}

	public String getSelectedText() {
		waitPresence();
		Select select = new Select(_webElement);
		return select.getFirstSelectedOption().getText();
	}

	public ElementHandler deselectAll() {
		waitPresence();
		Select select = new Select(_webElement);
		select.deselectAll();
		return this;
	}

	public boolean notPresent() {
		Boolean a;
		List elements = _driver.findElements(_by);
		if(elements.size()==0){
			try{
				_driver.findElement(_by).isDisplayed();
				a = false;
			}
			catch (Exception e){
				a = true;
			}
		}
		else {
			a = false;
		}
		return a;
	}

	public boolean isDisplayed() {
		waitPresence();
		boolean a = _webElement.isDisplayed();
		return a;
	}
	
	public boolean isSelected() {
		waitPresence();
		boolean sliderStatus = _webElement.isSelected();
		return sliderStatus;
	}

	public String getText() {
		waitPresence();
		String strVal = _webElement.getText();
		return strVal;
	}

	public String getAttribute(String name) {
		waitPresence();
		String strStatus = _webElement.getAttribute(name);
		return strStatus;
	}

	public ElementHandler leftPanelclick() throws InterruptedException {
		waitPresence();
		do {
			JavascriptExecutor js =(JavascriptExecutor)_driver;
			js.executeScript("arguments[0].click()", _webElement);
		}
		while (!(_driver.findElement(By.xpath("//*[@id=\"btnImport\"]")).isDisplayed()));
		return this;
	}

	public ElementHandler clickrepeat() {
		try {
			waitPresence();
			_webElement.click();
		} catch (Exception e) {
			_webElement.click();
		}
		return this;
	}

	public ElementHandler clear() {
		waitPresence();
		_webElement.clear();
		return this;
	}	

	public ElementHandler navigate() {
		waitPresence();
	_driver.navigate().refresh();
	return this;
	}
	
	public ElementHandler staleElementHandler() throws InterruptedException {
		_webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(_driver.findElement(_by))));
		return this;
	}
		
	public WebElement returnElement() {
		waitPresence();
		return _webElement;
	}
	
	public ElementHandler scrollDown(){
		waitPresence();
		JavascriptExecutor js = (JavascriptExecutor) _driver;
		js.executeScript("arguments[0].scrollIntoView(true);",_webElement);
	
	//js.executeScript("window.scrollBy(0,600)");	 	
	return this;
	}
	
	public ElementHandler selectSlider(boolean select){			
		if(!this.isSelected()){
			this._webElement.findElement(By.xpath("./..")).click();
			//this.click();
		}
		return this;
	}
	

}