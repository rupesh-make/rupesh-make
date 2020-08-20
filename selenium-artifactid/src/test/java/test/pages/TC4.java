package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.Iterator;
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

public class TC4 {

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
  
  @Test
  public void Login () throws IOException {
	  
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent handle is "+ parentHandle);
		//condition for login pop up 
		boolean condition = isElementPresent(driver,By.cssSelector(".makeFlex .autopop__wrap"));
		Set<String> handles =null;
		if(!condition) {
		driver.findElement(By.cssSelector("[data-cy='account']")).click();
		 handles = driver.getWindowHandles();
		System.out.println("Size is " + handles.size());
		
		driver.findElement(By.cssSelector("[data-cy='googleLogin'] .popupGoogleIcon")).click();
		//data-cy=""
		}
		else {
			//if small pop-up dnt come 
			waitForElementToBeClickable(driver,By.xpath("//span[text()='Google']")).click();
			handles = driver.getWindowHandles();
			System.out.println("Windows Size is " + handles.size());
				
		}
		
		Iterator<String> i1 = handles.iterator();
		  while(i1.hasNext())
		  {
		      String next_tab = i1.next();
		      if (!parentHandle.equalsIgnoreCase(next_tab))
		      {
		      driver.switchTo().window(next_tab);
		      }
		  }		
		 	    
		// code for gmail login        
		
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("xyz");
		driver.findElement(By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		
		driver.switchTo().window(parentHandle);
		
		System.out.println("----------------Test complete---------------");
/*		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        
        driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
        driver.switchTo().defaultContent();*/

	}
  @Test(priority=2)
  public void VerifyErrors() {
		
	    System.out.println("Enter into Flightbooking Errormessage");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    waitForElementToBeClickable(driver, By.xpath("//input[@data-cy='fromCity']")).click();
	   	WebElement option = driver.findElement(By.xpath("//div[contains(text(),'BOM')]"));
		option.click();
		 
		 //driver.findElement(By.xpath("//input[@data-cy='toCity']")).click(); 
		 waitForElementToBeClickable(driver, By.xpath("//div[contains(text(),'BOM')]")).click();
		 WebElement error =driver.findElement(By.xpath("//span[@data-cy='sameCityError']"));
		 System.out.println(error.getText());
		 //waitForElementToBeClickable(driver, By.xpath("//span[contains(text(),'DEPARTURE')]")).click();	
		
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
