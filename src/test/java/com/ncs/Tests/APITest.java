package com.ncs.Tests;

import org.testng.annotations.Test;

import com.ncs.Pages.WeatherAPI;
import com.ncs.Utilities.TestListener;
import com.ncs.Utilities.TestUtils;
import com.ncs.customreport.BaseClass;
import com.ncs.customreport.ReportGen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(TestListener.class)
public class APITest extends BaseClass{
	
	private WebDriver driver;
	WeatherAPI api;
	
	@BeforeTest
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}

	@AfterTest
	public void finaltest() throws Exception {
		extent.flush();
	}
	
  @Test
  public void TestAPILink() throws InterruptedException {
	  
	  api.scrollToFooter();
	  api.navToWeatherAPI();
	  
	  assertTrue(driver.getCurrentUrl().contains("https://www.wunderground.com/"));
	  
  }
  
  @BeforeClass
  public void setup() {
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://weather.com/");
      
      api = new WeatherAPI(driver);
	  
  }

  @AfterClass
  public void tearDown() {
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

