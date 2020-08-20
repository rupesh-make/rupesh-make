package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BasePage {
	
		
	protected WebDriver driver;
	protected WebDriverWait wait;	

	
	public BasePage()
	{
		this.driver=driver;
		wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
		
	}

}


