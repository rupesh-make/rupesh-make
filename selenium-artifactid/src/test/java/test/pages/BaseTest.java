package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
   	
	private WebDriver driver;
	
	@BeforeSuite
  public void beforeSuite() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver\\geckodriver.exe");
	  driver=new FirefoxDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  
	  driver.quit();
  }

}
