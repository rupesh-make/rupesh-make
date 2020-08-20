package com.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.util.Strings;

public class DatePicker {

public static WebDriver driver;


public static void Getdate (String monthName, Object day) throws ParseException {
	
	String currentMonth= driver.findElement(By.xpath("(//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])")).getText();
	if(!currentMonth.equalsIgnoreCase(monthName))
	{
		do{
			driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();
		}while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])")).getText().trim().equalsIgnoreCase(monthName));
		
	}
	int javaMonthInt= DatePicker.getMonthJavaInt(monthName);
	List<WebElement> allDateOfDesiredMonth= driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table/tbody[1]//td[(@class=' ' or @class=' ui-datepicker-week-end ' ) and @data-month='"+javaMonthInt+"']"));
	for(WebElement d:allDateOfDesiredMonth )
	{
		if(d.getText().trim().equals(day))
		{
			d.click();
			break;
		}
	}	
	
}

public static int getMonthJavaInt(String monthName) throws ParseException 
{

	Date date = new SimpleDateFormat("MMMM").parse(monthName);
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	return cal.get(Calendar.MONTH);
}		

		
public static void main(String[] args) throws ParseException {
{
	
	System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
	
	if(driver.findElements(By.className("autopop__wrap makeFlex column defaultCursor")).size()!=0)
	  {
		  driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	  }
	  else {

			  waitForElementToBeClickable(driver, By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
			   
			  
	  	 }
	
	
	
}
		  
		
		
		
		
		
		  //driver.findElement(By.xpath("//div/label[@for='fromCity']")).click();
		
		//driver.findElement(By.xpath("//div/label[@for='departure'])")).click();
		//driver.findElement(By.className("lbl_input latoBold appendBottom10")).click();
		// Locating departure date calendar
		//WebElement departCal= driver.findElement(By.id("hp-widget__depart"));
		//DatePicker.selectDate(departCal, "2017", "September", "22", driver);
		

	}


private static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
    remmovePopUpWindows(driver);
    return driver.findElement(locator);
	
}


private static void remmovePopUpWindows(WebDriver driver) {
	if(isElementPresent(driver, By.cssSelector(".wewidgeticon.we_close"))) {
    	driver.findElement(By.cssSelector(".wewidgeticon.we_close")).click();
	
}

}


private static boolean isElementPresent(WebDriver driver, By locator) {
	try {
		
		if(driver.findElement(locator).isDisplayed())
			return true;
	}
	catch(Exception e) {
		return false ;
	}
	return false;
	
}
}

		