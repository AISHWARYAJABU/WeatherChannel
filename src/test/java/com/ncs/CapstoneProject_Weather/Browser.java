package com.ncs.CapstoneProject_Weather;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	static WebDriver driver;
	
	public static WebDriver getDriverInstance(String browsertype) {
		
		if(browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browsertype.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		
		return driver;
		
	}

}
