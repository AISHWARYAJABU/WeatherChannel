package com.ncs.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ncs.Pages.SearchDDT;

public class SearchTestDDT {
	private WebDriver driver;
	private  SearchDDT searchddt;
	private static final int MAX_EXECUTIONS = 1; // Number of inputs to execute

	@BeforeClass 
	public void beforeClass() {

		
		driver = new ChromeDriver();
		searchddt = new SearchDDT(driver);
		searchddt.getweatherlink();
		driver.manage().window().maximize();
		searchddt.getweatherlink();
	}

	@AfterClass
	public void tearDown() {
		// Quit WebDriver
		if (driver != null) {
			driver.quit();
		}
	}

	 @Test(dataProvider = "cities", invocationCount = MAX_EXECUTIONS)
	public void searchForCity(String searchCity) throws InterruptedException {


		Thread.sleep(2000);

		searchddt.searchForCity(searchCity);

		Thread.sleep(3000);
		
		// Assert that the city name displayed after searching matches the expected city name
        String cityName = searchddt.getCityName();
        Assert.assertEquals(cityName, searchCity, "Incorrect city name displayed after search");
    
		

	}

    @DataProvider(name = "cities")
    public Object[][] searchData() {
        return new Object[][]{
                {"Mumbai"},
                {"Solapur"},
                {"Hyderabad"}
        };
    }
}
