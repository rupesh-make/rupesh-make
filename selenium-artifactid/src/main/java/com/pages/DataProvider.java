package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProvider {

	public static String Getdata( String key) throws IOException {
		
		FileInputStream input= new FileInputStream("D:\\Eclipse-Oxygen\\selenium-artifactid\\config.properties");
		Properties prop =new Properties();
		prop.load(input);
		return prop.getProperty(key); 
		

	}

}
