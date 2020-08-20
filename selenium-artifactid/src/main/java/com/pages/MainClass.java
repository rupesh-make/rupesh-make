package com.pages;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MainClass {
  
   
  WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  
	 System.setProperty("webdriver.chrome.driver","D:\\Software\\geckodriver\\geckodriver.exe");
	  driver=new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  
	 
	  
  }

  @Test
  public void VerifySearch() {
	  
	  driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	  driver.navigate().to("https://demoqa.com/elements");
	  WebElement element= driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
			  
	  element.click();
	  /*String Textboxname = "Text Box";
	  String text= element.getAttribute("value");
	  Assert.assertEquals(text, Textboxname, "Text not found");*/
	  
	 WebElement textbox= driver.findElement(By.id("userName"));
	 textbox.sendKeys("Testusername");
	 String text= textbox.getAttribute("value");
	 Assert.assertEquals(text, "Testusername", "Text not found");	
	 System.out.println("Testusername");
	 
	 WebElement useremail= driver.findElement(By.id("userEmail"));
	 useremail.sendKeys("test@gmail.com");
	 String mail= useremail.getAttribute("value");
	 Assert.assertEquals(mail, "test@gmail.com", "Text not found");	
	 System.out.println("test@gmail.com");
	 
	 	 
	 WebElement usereadrees= driver.findElement(By.id("currentAddress"));
	 usereadrees.sendKeys("Nagpur");
	 String addrees= useremail.getAttribute("value");
	 Assert.assertEquals(addrees, "Nagpur", "Text not found");	
	 System.out.println("Nagpur");
	 
	 
	 WebElement userpermanant= driver.findElement(By.id("permanentAddress"));
	 userpermanant.sendKeys("Pune");
	 
	 String permanant= useremail.getAttribute("value");
	 Assert.assertEquals(permanant, "Pune", "Text not found");	
	 System.out.println("Pune");
	
	 
	 
	 WebElement button= driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	 button.submit();
	   
	 
	  
  }
  
  
}
