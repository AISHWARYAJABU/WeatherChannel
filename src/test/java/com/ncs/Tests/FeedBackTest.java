package com.ncs.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ncs.Pages.FeedbackPage;
import com.ncs.Utilities.TestListener;
import com.ncs.Utilities.TestUtils;
import com.ncs.customreport.BaseClass;
import com.ncs.customreport.ReportGen;

@Listeners(TestListener.class)
public class FeedBackTest extends BaseClass{
	
	private WebDriver driver;
	private FeedbackPage fdb;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://weather.com/");
	}
	@BeforeTest
	public void initialsetup() throws Exception {
		ReportGen.reportCreation();
	}
	
	
	 @Test
	    public void GoToFeedbackLink() throws InterruptedException {
	        fdb = new FeedbackPage(driver);

	        fdb.scrollToFooter();
	        fdb.goToFeedBack();
	        fdb.feedbackInNewTab();
	        
	        assertTrue(driver.getCurrentUrl().contains("https://support.weather.com/"));
	                
	    }
	
	@AfterTest
	public void finaltest() throws Exception {
		extent.flush();
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

