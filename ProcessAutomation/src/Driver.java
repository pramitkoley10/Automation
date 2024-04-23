import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;
	
	public static WebDriver driverBase() {
    
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		return driver;
	}
	public static Login_page loginBase() throws InterruptedException {
		WebDriver driver = driverBase();
		System.setProperty("webdriver.chrome.driver", "C:/PathToChromeDriver/chromedriver.exe");
		Login_page login = new Login_page(driver);
		login.getLogin();
		return login;
	}
}
