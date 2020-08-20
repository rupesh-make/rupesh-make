package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MakeTrip {
  public WebDriver driver;
	
	@Test
  public void f() {
		
	
		if(driver.findElement(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='makeFlex googleLoginBtn flexOne']")).click();
			
		}
		else
		{
			driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		}
	
  }
  @BeforeTest
  public void beforeTest() {
	  
	    System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		//driver.navigate().refresh();
  }

  @AfterTest
  public void afterTest() {
  }

}
