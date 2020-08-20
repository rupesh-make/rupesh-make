package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class RadioButton {
 
	private static 
	
	WebDriver driver;
	//WebDriverWait wait;
	
	@BeforeClass
  public void beforeTest() {
	 
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		 
		
  }

  
  @Test
  public void VerifyRadio() {
	      		
	    		
	  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.navigate().to("https://demoqa.com/radio-button");
	     
	     	//WebDriverWait wait= new WebDriverWait(driver,3);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='mb-3']")));
			
	   WebElement Radiobutton=  driver.findElement(By.id("impressiveRadio"));
	   
	     if(Radiobutton.isSelected()==false)
	     {
	    	 Radiobutton.click();
	     }
  
	     System.out.println("You have selected Impressive");
  }
  @AfterClass
  public void afterTest() {
     
  }

}
