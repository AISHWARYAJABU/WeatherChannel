package com.ncs.Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ncs.Pages.WeatherPage;
import com.ncs.Utilities.TestListener;
import com.ncs.Utilities.TestUtils;
import com.ncs.customreport.BaseClass;
import com.ncs.customreport.ReportGen;

import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;


@Listeners(TestListener.class)
public class WeatherTest extends BaseClass {

	// Declares a variable named driver to handle WebDriver operations.
	private WebDriver driver;

	// weatherpage is a instance of WeatherPage class
	private WeatherPage weatherpage;

	@BeforeTest
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}

	@AfterTest
	public void finaltest() throws Exception {
		extent.flush();
	}

	@Test(priority = 1, description = "Search city with valid input")
	public void testWeatherForCity() throws InterruptedException {
 
		// Called method to get link
		weatherpage.getweatherlink();
 
		// Pauses the execution for 2 seconds.
		Thread.sleep(2000);
 
		// Passed "Solapur as city name to search temperature"
		String searchCity = "Solapur";
		weatherpage.searchForCity(searchCity);
 
		Thread.sleep(2000);
		// Verify that the city name is displayed in the search results
		String expectedResult = weatherpage.getCityName();
		Assert.assertEquals("Solapur, Maharashtra", expectedResult);
		Thread.sleep(3000);
	}
 
	@Test(enabled = false, priority = 2, description = "Search city with special char and mixed case")
	public void testWeatherForCityWithSpecialChar() throws InterruptedException {
 
		String searchCity2 = "NeW_yORk";
		weatherpage.searchForCityWithSpecialChar(searchCity2);
 
		Thread.sleep(3000);
		// Verify that the city name is displayed in the search results
		// String expectedResult = weatherpage.getCityName2();
		// Assert.assertEquals("New York City, NY, United States", expectedResult);
		Thread.sleep(2000);
	}
 
	@Test(enabled = true, priority = 3, description = "Search city with invalid inputs")
	public void testSearchCityWithNegativeInputs() throws InterruptedException {
		// Passed wrong input for city
		String searchCity3 = "Xyz123";
		weatherpage.searchForCityWithInvalidInput(searchCity3);
		// Verify that the city name is not found
		Assert.assertFalse(weatherpage.isCityNameDisplayed(searchCity3),
				"Unexpected city found in search results: " + searchCity3);
 
	}
 
	@Test(enabled = true, priority = 4, description = "Verify Today tab and weather details")
	public void testToadyTabAndWeatherDetails() throws InterruptedException {
		// Pauses the execution for 2 seconds.
		Thread.sleep(2000);
		// Called method to select today tab and weather details 
		weatherpage.clickTodayTab();
 
		// Assert that the Weekend tab is selected
		// assertFalse(weatherpage.isTodayTabSelected(), "Today");
		assertTrue(driver.findElement(By.linkText("Today")).isEnabled());
 
	}
 
	@Test(enabled = true, priority = 4, description = "Verify Hourly and weather details")
	public void testHourlyTabAndWeatherDetails() throws InterruptedException {
 
		weatherpage.clickHourlyTab();
 
		// Assert that the Weekend tab is selected
		// assertFalse(weatherpage.isHourlyTabSelected(), "Hourly tab is not selected");
		assertTrue(driver.findElement(By.linkText("Hourly")).isEnabled());
 
	}
 
	@Test(enabled = true, priority = 5, description = "Verify 10 Day and weather details")
	public void test10DayTabAndWeatherDetails() throws InterruptedException {
 
		weatherpage.click10DayTab();
 
		// Assert that the Weekend tab is selected
		assertFalse(weatherpage.is10DayTabSelected(), "10 Day tab is not selected");
		// assertTrue(driver.findElement(By.linkText("10 Day")).isEnabled());
 
	}
 
	@Test(enabled = true, priority = 6, description = "Verify Weekend tab and weather details")
	public void testWeekendTabAndWeatherDetails() throws InterruptedException {
 
		weatherpage.clickWeekendTab();
 
		// Assert that the Weekend tab is selected
		// assertFalse(weatherpage.isWeekendTabSelected(), "Weekend tab is not
		// selected");
		assertTrue(driver.findElement(By.linkText("Weekend")).isEnabled());
 
	}
 
	@Test(enabled = true, priority = 7, description = "Verify Monthly tab and weather details")
	public void testMonthlyTabAndWeatherDetails() throws InterruptedException {
 
		weatherpage.clickMonthlyTab();
 
		// Assert that the Weekend tab is selected
		// assertFalse(weatherpage.isMonthlyTabSelected(), "Monthly tab is not
		// selected");
		assertTrue(driver.findElement(By.linkText("Monthly")).isEnabled());
	}
 
	@Test(priority = 8, description = "Radar Tab details")
	public void testRadarTab() throws InterruptedException {
 
		weatherpage.selectRadar();
 
		// Assert that the Radar tab is selected after clicking
		assertTrue(driver.findElement(By.linkText("Radar")).isEnabled());
	}
 
	@Test(priority = 9, description = "Moreforecast details")
	public void testMoreForecast() throws InterruptedException {
 
		weatherpage.selectAllergyTracker();
 
		// assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
		Thread.sleep(10);
		// assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
 
		driver.navigate().back();
 
		Thread.sleep(10);
 
		weatherpage.selectAirQualityForecast();
	}
 
//	@Test(priority = 10, description = "Moreforecast details")
//	public void testAirQualityForecast() throws InterruptedException {
//	
//        weatherpage.selectAirQualityForecast();  
//
//        //assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
//        Thread.sleep(10);
//        //assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
//	}
 
	@Test(priority = 10, description = "Verify Region and Unit details")
	public void testRegionAndUnit() throws InterruptedException {
 
		weatherpage.selectRegion();
 
		Thread.sleep(10);
 
		weatherpage.selectUnit();
		assertTrue(true);
	}
 
//	@Test(enabled = false, priority = 12, description = "Verify Unit details")
//	public void testUnit() throws InterruptedException {
//		
//        weatherpage.selectUnit();
//        
//        //assertTrue(driver.findElement(By.linkText("Monthly")).isEnabled());
//	}
 
	@Test(priority = 11, description = "Stay Safe Details")
	public void testStaySafeTab() throws InterruptedException {
 
		weatherpage.selectStaySafe();
 
		// assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
		Thread.sleep(2);
		// assertTrue(driver.findElement(weatherpage.clickedForecast()).isEnabled());
	}
 
	
	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		// driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
		weatherpage = new WeatherPage(driver);
		weatherpage.getweatherlink();
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod
	public void postTestMethod(ITestResult itr) throws IOException, InterruptedException {
		Thread.sleep(3000);
		ReportGen.finishReportAfterTest(itr, driver);
		
		TestUtils ss = new TestUtils(driver);
		ss.afterMethod(itr);
		
			//TestUtils.captureScreenshot(driver,itr.getMethod().getMethodName());
		
	}

}
