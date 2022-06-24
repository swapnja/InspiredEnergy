package Incubyte;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Incubyte extends AbstractTest{
  public Incubyte() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
  public void f() throws InterruptedException {
	 driver.findElement(By.linkText("Gmail")).click();
	 Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
  }
}
