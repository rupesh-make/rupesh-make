package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CheckBoX  {
 
	 WebDriver driver;
  @BeforeTest
  public void beforeClass() 
  
  {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver\\geckodriver.exe");
	  driver=new FirefoxDriver();
  }

  @AfterTest
  public void afterClass() {
	  
	  
  }
  @Test
  
  public void verifyCheckBox()
    
  {
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.navigate().to("https://demoqa.com/checkbox");
     WebElement  checkboxElement = driver.findElement(By.className("rct-checkbox"));
     
     if(checkboxElement.isSelected()==false)
     {
    	 checkboxElement.click();
     }
	  
     System.out.println("You have selected :homedesktopnotescommands");
  }
  
  }
