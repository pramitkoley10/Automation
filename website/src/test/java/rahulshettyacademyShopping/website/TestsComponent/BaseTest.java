package rahulshettyacademyShopping.website.TestsComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademyShopping.website.PageObjects.landingpage;

public class BaseTest {

	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademyShopping//website//Resources//GlobalData.properties");
		prop.load(file);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		 
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			  driver = new FirefoxDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		 return driver;
	}
	
	public landingpage lunchApplication() throws IOException {
		WebDriver driver = initializeDriver();
		landingpage login = new landingpage(driver);
		login.goTo();
		return login;
	}

}
