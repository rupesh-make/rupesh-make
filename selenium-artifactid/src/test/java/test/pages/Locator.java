package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Locator {
	
	WebDriver driver;
	   
  @BeforeTest
  public void beforeTest() {
	  
  System.setProperty("webdriver.gecko.driver", "D:\\Software\\geckodriver\\geckodriver.exe");
	  driver= new FirefoxDriver();
		      
  }

  @AfterTest
  public void afterTest() {
	  
	  //driver.quit();
  }
  
  @Test
  public void Verifyauthentication() {
	  
	  driver.navigate().to("https://www.facebook.com");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  //select Logo of facebook
	  
	  driver.getTitle();
	  	  
	  WebElement logo= driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]"));
	  logo.click();
	  if(driver.getTitle().equals("Go to Facebook home"));
	  System.out.println("We are on home page");
	  
	  
	  
	  WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	  email.sendKeys("rupeshramteke@gmail.com");
	  
	  WebElement password= driver.findElement(By.xpath("//*[@id=\"pass\"]"));
	  password.sendKeys("Sanyo@1983");
	  
	  
	  
  
	  
	  
	  
	  WebElement button = driver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
	  button.submit();
	  
	  System.out.println("Login Successful");
	  
	  
  }
  
 

}
