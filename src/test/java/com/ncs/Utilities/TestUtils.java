package com.ncs.Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class TestUtils {
	
	WebDriver driver;
	public TestUtils (WebDriver driver) {
		this.driver=driver;
		
	}

	public void afterMethod(ITestResult itr) throws IOException, InterruptedException {
		Thread.sleep(3000);
			if(itr.isSuccess()) {
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String path = System.getProperty("user.dir")+"/passed-screenshots/"+itr.getMethod().getMethodName()+"/screenshot.png";
			File imagefile = new File(path);
			
			FileUtils.copyFile(source, imagefile);	
		}
			else {
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				String path = System.getProperty("user.dir")+"/failed-screenshots/"+itr.getMethod().getMethodName()+"/screenshot.png";
				File imagefile = new File(path);
				
				FileUtils.copyFile(source, imagefile);	
			}

}
}


//public class TestUtils {
//	
//	// capture screenshots
//	
//	public static String captureScreenshot(WebDriver driver,String method) throws IOException {
//		
//		String filepath = System.getProperty("user.dir")+"/passed-screenshots/"+method+".png";
//		
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		File destination = new File(filepath);
//		
//		FileUtils.copyFile(source, destination);	
//		
//		return filepath;
//		
//	}
//}
