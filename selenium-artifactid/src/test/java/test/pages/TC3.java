package test.pages;

import org.testng.annotations.Test;

import com.pages.DataProvider;

import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TC3 {

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
		  
		  Set<String> allWindows = driver.getWindowHandles();
		  for(String curWindow : allWindows)
		  {
		  driver.switchTo().window(curWindow);
		  }
		
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("rupeshramteke@gmail.com");
		driver.findElement(By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Sanyo@1983");
		driver.findElement(By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
		
		driver.switchTo().window(parentHandle);
		System.out.println("----------------Test complete---------------");

	}
  
   @Test(priority=2)
	  public void VerifyFlights() {
			
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	    try {
	        waitForElementToBeClickable(driver, By.xpath("//input[@data-cy='fromCity']")).click();
	 	   	WebElement option = driver.findElement(By.xpath("//div[contains(text(),'BOM')]"));
	 		option.click();
		    //waitForElementToBeClickable(driver,By.xpath("//div[contains(text(),'BOM')]")).click();
	 		driver.findElement(By.xpath("//div[contains(text(),'DEL')]")).click();	
	 		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
			/*Actions act = new Actions(driver);
	        act.sendKeys(Keys.ARROW_RIGHT).build().perform();
	        System.out.println("Scroll right perfomed");*/
			driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Sep 25 2020')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
			
			wait= new WebDriverWait(driver,30);			
			List<WebElement> NoOfFlights = driver.findElements(By.xpath("//div[@id='left-side--wrapper']//div[@class='fli-list one-way']"));
			
			System.out.println(NoOfFlights.size());
			
			for(WebElement ele:NoOfFlights )
			{
				String flightName= ele.getText();
				System.out.println(flightName);
			}
		    
	 	    }
   
   			catch(Exception e) {
   				
   				System.out.println("Exeception is catched");
   			}
   			
   }		
   			//System.out.println(driver.findElement(By.xpath("//input[@id='fromCity']")).getText());
			//System.out.println(driver.findElement(By.xpath("//input[@id='toCity']")).getText());
			
			
	  
  
  
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
