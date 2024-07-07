package Cleversort.com.cleversort;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Driver {
	
	static String browser1;
	
	
	public static WebDriver driver(String data) throws Exception {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//	   WebDriver driver = new ChromeDriver();
		WebDriver driver;
		String browser =  data;
		if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
            driver = new FirefoxDriver(options);

} else if(browser.equalsIgnoreCase("chrome")) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless=new");
	driver = new ChromeDriver(options);
}else if(browser.equalsIgnoreCase("Edge")) {
	EdgeOptions options = new EdgeOptions();
	options.addArguments("--headless=new");
	driver = new EdgeDriver(options);
}else{
	throw new Exception("Incorrect Browser");
	}
		
		
		
		
		
	   driver.manage().window().maximize();
       return driver;
	}
	
	
	
	
	
	
	
	
	@Test(dataProvider = "runTime", invocationCount = 4, threadPoolSize = 4)
	public static void login(String data) throws Exception {
		
		
		WebDriver driver = driver(data);
		LoginPage loading = new LoginPage(driver);
		loading.loginPage();
		driver.close();
	}
	
	
//	@DataProvider(parallel= true)	
//	public static Object[] runTime() {
//		int n = 2;
//		Object[] data = new Object[n];
//		
//		for(int i=0;i<=n-1;i++) {
//			data[i] = i;
//			
//			
//		}
//		return data;
//	}
//	
	
	@DataProvider(parallel= true)	
	public static Object[] runTime() {
		int n = 2;
		Object[] data = new Object[n];
		
		
		data[0] = "firefox";
		data[1] = "chrome";
			
			
		
		return data;
	}
	
	
	
	
	
//	@BeforeTest
//	@Parameters("browser")
//	public static void parameter(String browser) {
//	 browser1 = browser;
//		
//	}
	
	
}
