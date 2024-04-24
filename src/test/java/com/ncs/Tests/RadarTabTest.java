package com.ncs.Tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit; 
import static org.testng.Assert.assertTrue;
import java.io.IOException; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ncs.Pages.RegionTabPage;
import com.ncs.Utilities.TestListener;
import com.ncs.Utilities.TestUtils;
import com.ncs.customreport.BaseClass;
import com.ncs.customreport.ReportGen;

 
@Listeners(TestListener.class)
 
public class RadarTabTest extends BaseClass{
	    // Declares a variable named driver to handle WebDriver operations.
		private WebDriver driver;
		// Weatherpage is a instance of WeatherPage class
		private RegionTabPage weatherpage1;
		@BeforeTest
		public void initialsetup() throws Exception {
			ReportGen.reportCreation();
		}
		@AfterTest
		public void finaltest() throws Exception {
			extent.flush();
		}
		@Test(enabled = true, priority = 10, description = "Verify Region and Unit details")
		public void testRegionAndUnit() throws InterruptedException {
 
			weatherpage1.selectRegion();
 
			Thread.sleep(10);
 
			weatherpage1.selectUnit();
			assertTrue(true);
		}
 
		
		@BeforeClass
		public void beforeClass() {

			driver = new ChromeDriver();
			// driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
			weatherpage1 = new RegionTabPage	(driver);
			//weatherpage1.getweatherlink();
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