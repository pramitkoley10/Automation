package com.cpnc.CPnCResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsData {

	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(path);
		Reporter.config().setReportName("Test Automation Report");
		Reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports Extent = new ExtentReports();
		Extent.attachReporter(Reporter);
		Extent.setSystemInfo("Tester", "Pramit Koley");
		return Extent;
	}
}
