package Demo;

import java.security.cert.PKIXRevocationChecker.Option;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// This code is created by Pramit koley.

		WebDriver Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(Driver, Duration.ofSeconds(10));

		// Open Website
		Driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Driver.manage().window().maximize();

		// Login page
		String a[] = getname(Driver);

		Driver.findElement(By.xpath("//input[@id='username']")).sendKeys(a[0]);
		Driver.findElement(By.xpath("//input[@id='password']")).sendKeys(a[1]);
		Driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
		Driver.findElement(By.id("okayBtn")).click();

		Select dropdown = new Select(Driver.findElement(By.xpath("//select[@class='form-control']")));

		dropdown.selectByValue("stud");
		Driver.findElement(By.id("terms")).click();
		Driver.findElement(By.id("signInBtn")).click();

		// ADD TO CART
		addToCart(Driver, w);

	}

	public static String[] getname(WebDriver Driver) {
		String a[] = { "a", "b" };
		a[0] = Driver.findElement(By.xpath("//p[@class='text-center text-white']/b[1]")).getText();
		a[1] = Driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();
		return a;
	}

	public static void addToCart(WebDriver Driver, WebDriverWait W) {
		W.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		// Shopping page
		List<WebElement> items = Driver.findElements(By.cssSelector(".btn.btn-info"));
		for (int i = 0; i < items.size(); i++) {
			Driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
		}
		Driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

	}

}
