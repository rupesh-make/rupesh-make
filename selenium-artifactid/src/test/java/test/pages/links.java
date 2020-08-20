package test.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class links {
	
	WebDriver driver;
	 
 
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
		 
		
	  
  }

   @Test
   public void Test() {
	   
	   
	   driver.get("http://www.google.com");
	   
	   List<WebElement> link= driver.findElements(By.tagName("a"));
	   
	   
	   for(int i=0; i<link.size();i++)
	   {
		  WebElement ele= link.get(i);
		  String url= ele.getAttribute("href");
		  
		  //System.out.println(url.toString());
		  
	   } 		
	   }
   
	   public static void verifyLink( String linkurl) throws IOException 
 {
	  try {
		URL url = new URL(linkurl);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setConnectTimeout(3000);
		http.connect();
		if(http.getResponseCode()!=200)
		{
			System.out.println(linkurl);
		}
		
	  }
		catch(Exception e ) {
			
			
	  }
 
 }     
@AfterClass
  
  public void afterClass() {
  
	
	driver.close();

}
}
