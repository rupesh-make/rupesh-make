package test.pages;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase2 {
  
	public WebDriver driver;  
	public WebDriverWait wait;
   
   @BeforeTest
   
   public void beforeTest()
   {
	    
	   ChromeOptions options = new ChromeOptions();
	   
	   System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	   driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();
	    //driver.navigate().refresh();
	   
   }		
		

  
  @Test(priority=1)
  public void Login () {
	  
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
	  
	  
	  WebElement username = driver.findElement(By.xpath("//input[contains(@name, 'identifier')]"));
	  username.sendKeys("rupeshramteke@gmail.com");
	  
	  waitForElementToBeClickable(driver,By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
	  driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Sanyo@1983");
	  waitForElementToBeClickable(driver,By.xpath("//button[.//span[contains(text(),'Next')]]")).click();
	  
	  
	  driver.switchTo().window(parentHandle);
	  driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
	  //driver.navigate().refresh();
	  WebDriverWait wait =  new WebDriverWait (driver,20);
	  
	  try {
		    WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@data-cy='loggedInUser']")));
		    System.out.println(login.getText());
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@data-cy='loggedInUser']")));
		    System.out.println(login.getText());
		}
	  
	  System.out.println("login Successful");
	  
	  waitForElementToBeClickable(driver, By.xpath("//p[@data-cy='loggedInUser']")).click();
	  waitForElementToBeClickable(driver,By.xpath("//p[contains(text(),'Logout')]")).click();
	  	  
	  System.out.println( "Logout successful");
	 
	  
  }
  
private WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
    return driver.findElement(locator);
}



private boolean isElementPresent(WebDriver driver, By locator) {
	try {
		if(driver.findElement(locator).isDisplayed())
			return true;
	}
	catch(Exception e) {
		return false ;
	}
	return false;

}



@AfterTest
  public void afterTest() {
	  
	  //driver.close();
  }

}

	
    


