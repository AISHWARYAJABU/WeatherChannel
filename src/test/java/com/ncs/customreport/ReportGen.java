package com.ncs.customreport;

import java.io.IOException;
import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ncs.Utilities.TestUtils;

public class ReportGen extends BaseClass{
	
	
	public static void reportCreation() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("reports/reports.html");
		extent.attachReporter(spark);
	}

	public static void finishReportAfterTest(ITestResult itr, WebDriver driver) throws IOException {
		
		extenttest = extent.createTest(itr.getTestClass().getName()+"-"+itr.getMethod().getMethodName());
				
		if(itr.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS,"Weather - Test is executed Successfully");
			extenttest.log(Status.INFO, "Check if this success message is displayed");
		}else if(itr.getStatus() == ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, "Weather - Test is failed,Not Executed");
			extenttest.log(Status.INFO, "Check if this failed message is displayed");

			
		}else if(itr.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "Weather - Test is skipped,Not Executed");
			extenttest.log(Status.INFO, "Check if this skipped message is displayed");
		}
		
		
	}
	

}

