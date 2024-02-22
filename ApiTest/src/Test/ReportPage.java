package Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportPage {
	public ExtentReports getReport() {
		String path = System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test");
		reporter.config().setReportName("Auto Report Generator");
		 ExtentReports extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pramit koley");
		return extent;
	}

}
