import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This code is created by Pramit koley.
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0 ,500)", "");
		List<WebElement> a = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		int n = a.size();
		System.out.println("number of Rows:"+n);
		
		List<WebElement> b = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		int m = b.size();
		System.out.println("number of Column:"+m);

	}

}
