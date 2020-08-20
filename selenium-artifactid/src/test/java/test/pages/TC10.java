package test.pages;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.JavascriptExecutor;

public class TC10 {
   public WebDriver driver;
	
	
	@Test
  public void VerifyLogo() throws Exception {
	  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean ImageFile = driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']/img")).isDisplayed();
		
		if(!ImageFile) {
			
			System.out.println("Image is not present");
			
		}
		else
		{
			System.out.println("Image is  Present");
		}
	    
	}
	  
  
  
  
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions options = new ChromeOptions();  
	  System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	  driver = new ChromeDriver(options);
	  driver.get("https://www.makemytrip.com/");
		//driver.navigate().refresh();
	  
  }

  @AfterTest
  public void afterTest() {
  }
  
}
