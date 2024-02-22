package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Api {

	ChromeDriver driver;
	public Api(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}

	public void data() {
		// TODO Auto-generated method stub

		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
		

}
