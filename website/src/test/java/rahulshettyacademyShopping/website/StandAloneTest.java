package rahulshettyacademyShopping.website;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademyShopping.website.PageObjects.landingpage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productname="ADIDAS ORIGINAL";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		landingpage login = new landingpage(driver);
		login.goTo();
		
		login.logindata("Pramitkoley@mail.com","Password@123");
		
		//main page
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		WebElement product = items.stream().filter(item->item.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		product.findElement(By.cssSelector(".btn.w-10.rounded:last-child")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("Product Added To Cart")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//add to cart
		List<WebElement>addtocartlists = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean ans = addtocartlists.stream().anyMatch(addtocartlist->addtocartlist.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(ans);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		//payment page
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa.fa-search")));
		Actions a =new Actions(driver);
		a.scrollToElement(driver.findElement(By.cssSelector(".form-group input"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		
		driver.findElement(By.cssSelector(".actions a")).click();
		
		//final page
		String Thankyou = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Thankyou.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		driver.close();

	}

}
