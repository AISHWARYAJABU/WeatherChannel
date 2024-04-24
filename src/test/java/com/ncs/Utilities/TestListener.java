package com.ncs.Utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ncs.customreport.ReportGen;

public class TestListener implements ITestListener {
	
	
	  @Override
	  public void onTestSkipped(ITestResult itr) {
	  		 
		  try {
			ReportGen.finishReportAfterTest(itr, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }



}
