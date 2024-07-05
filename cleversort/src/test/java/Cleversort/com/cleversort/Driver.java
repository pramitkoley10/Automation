package Cleversort.com.cleversort;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Driver {
	public static WebDriver driver() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
       return driver;
	}
	@Test(dataProvider = "runTime", invocationCount = 5, threadPoolSize = 5)
	public static void login(int data) throws InterruptedException, IOException {
		
		
		WebDriver driver = driver();
		LoginPage loading = new LoginPage(driver);
		loading.loginPage();
		driver.close();
	}
	
	
	@DataProvider(parallel= false)	
	public static Object[] runTime() {
		int n = 1;
		Object[] data = new Object[n];
		
		for(int i=0;i<=n-1;i++) {
			data[i] = i;
			
			
		}
		return data;
	}
	
	
}
