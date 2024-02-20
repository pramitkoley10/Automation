package rahulshettyacademyShopping.website.TestsComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int maxlimit = 1;
	public boolean retry(ITestResult result) {
		if(count<maxlimit) {
			count++;
			return true;
		}
		return false;
	}
}