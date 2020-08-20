package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TC8 {

	public static WebDriver driver;
	public static WebDriverWait wait;
  
   
   @BeforeTest
   
   public void beforeTest()
   {
	    
	   
	   System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	   driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		//driver.navigate().refresh();
	   	   
   }
  
   
	  @Test(priority=1)
	  public void Login () throws IOException {
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
		   
		  String parentHandle = driver.getWindowHandle();
		  boolean condition = isElementPresent(driver,By.cssSelector(".makeFlex .autopop__wrap"));
		  Set<String> handles =null;
		  if(!condition) {
				driver.findElement(By.cssSelector("[data-cy='account']")).click();
				handles = driver.getWindowHandles();
					
				waitForElementToBeClickable(driver, By.xpath("//span[contains(text(),'Login with Google')]")).click();
		  }
		  
		  else
		  {
		  
				waitForElementToBeClickable(driver,By.xpath("//span[text()='Google']")).click();
				handles = driver.getWindowHandles();
				System.out.println("Windows Size is " + handles.size());
		  
		  }
		  	  
		 	   
		  Set<String> allWindows = driver.getWindowHandles();
		  for(String curWindow : allWindows)
		  {
		  driver.switchTo().window(curWindow);
		  }
		  
		  
		  WebElement username = driver.findElement(By.xpath("//*[@id='identifierId']"));
		  username.sendKeys("rupeshramteke@gmail.com");
		  
		  waitForElementToBeClickable(driver,By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		  driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Sanyo@1983");
		  waitForElementToBeClickable(driver,By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		  		  
		  driver.switchTo().window(parentHandle);
		  driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
		  //driver.navigate().refresh();
		  //WebDriverWait wait =  new WebDriverWait (driver,20);
		  
		  
		  
		  
	}
  @Test(priority=2)
  public void VerifyLinks() {
		
	 try {
		 
	  wait = new WebDriverWait(driver, 60);
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  
	  System.out.println(links.size());
	  
	  for (int i = 1; i<=links.size(); i=i+1)
	  
	  {
	  
	  System.out.println(links.get(i).getText());
	  
	  }
	 }  
	  catch (Exception e) {
		  
		  System.out.println("Error Catched");
	  }
	  
	  }
  	
  
	public static boolean isElementPresent(WebDriver driver , By locator) {
		try {
			if(driver.findElement(locator).isDisplayed())
				return true;
		}
		catch(Exception e) {
			return false ;
		}
		return false;
	}
	
	// element to clickable
	public WebElement waitForElementToBeClickable(WebDriver driver , By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.elementToBeClickable(locator));
      remmovePopUpWindows(driver);
      return driver.findElement(locator);
  }
	//remove add pop up
	public static void remmovePopUpWindows(WebDriver driver) {
		if(isElementPresent(driver, By.cssSelector(".wewidgeticon.we_close"))) {
      	driver.findElement(By.cssSelector(".wewidgeticon.we_close")).click();
      }
	}
@AfterTest
  public void afterTest() {
	  
	  //driver.close();
  }

}
