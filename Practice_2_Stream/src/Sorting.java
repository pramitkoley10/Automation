import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//div[@class='cart']/a[2]")).click();
		String w1 = window(driver);
		sorting(driver);
		driver.close();
		w.until(ExpectedConditions.numberOfWindowsToBe(1));
		driver.switchTo().window(w1);
		driver.close();
	}
	
	public static String window(WebDriver driver) {
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> ir = windows.iterator();
		String w1 = ir.next();
		String w2 = ir.next();
		driver.switchTo().window(w2);
		return (w1);
	}
	
	public static void sorting(WebDriver driver) {
		List<WebElement> Elements=driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		
		ArrayList<String>vegs = new ArrayList(Elements.size());
		for(int i=0;i<Elements.size();i++) {
			vegs.add(driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr")).get(i).getText());
		}
		List<String>newvegs = vegs.stream().sorted().collect(Collectors.toList());
			
		    newvegs.stream().sorted().forEach(s->System.out.println(s));
		
		
	}
	
	

}
