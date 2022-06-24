//To test the compose function in Gmail, to send an email with the body "Automation QA test for Incubyte" and subject "Incubyte"

package Incubyte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class composeGmailTest {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "Z:\\incubyte\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
	driver.manage().window().maximize();
	
	driver.get("https://www.gmail.com");	
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("incubyte1988@gmail.com");
	driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
	WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
	passwordButton.sendKeys("test@1988");
	driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
	driver.findElement(By.xpath("//div[text()='Compose']")).click();
	driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("swapnjagudle9@gmail.com");
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Incubyte");
	driver.findElement(By.xpath("//*[@id=\":9r\"]")).sendKeys("Automation QA test");
	driver.findElement(By.xpath("//div[text()='Send']")).click();
	}
	}
