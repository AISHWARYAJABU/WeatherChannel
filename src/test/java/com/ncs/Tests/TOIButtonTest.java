package com.ncs.Tests;

import org.testng.annotations.Test;

import com.ncs.Pages.NavToTOI;
import com.ncs.Utilities.TestListener;
import com.ncs.Utilities.TestUtils;
import com.ncs.customreport.BaseClass;
import com.ncs.customreport.ReportGen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(TestListener.class)
public class TOIButtonTest extends BaseClass{
	
	private WebDriver driver;
	private NavToTOI toi;
	
	@BeforeTest
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}

	@AfterTest
	public void finaltest() throws Exception {
		extent.flush();
	}
	
  @Test
  public void testTOILink() throws InterruptedException {
	  toi = new NavToTOI(driver);
	  toi.switchToTOI();
	  
	  String fetchedURL = driver.getCurrentUrl();
	  String actualURL = "https://timesofindia.indiatimes.com/";
	  
	  assertEquals(fetchedURL, actualURL);
  }
  @BeforeClass
  public void setup() {
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://weather.com/");
  }

  @AfterClass
  public void teradown() {
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

