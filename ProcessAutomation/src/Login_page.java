import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	WebDriver driver;
	public Login_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	@FindBy (css = ".btnStyle1")
//	WebElement signin;
	By FindBy = By.cssSelector(".btnStyle1");

	public void getLogin() throws InterruptedException {
        
		driver.get("https://dev.nexus.insightavenue.ai/login");
		Actions a = new Actions(driver);
		driver.findElement(FindBy).click();
		Thread.sleep(10000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String F = it.next();
		String L = it.next();
		
		driver.switchTo().window(L);
		
		driver.findElement(By.id("userName")).sendKeys("pramit.koley@digitalavenues.com");
		
		driver.findElement(By.id("password")).sendKeys("Koley@321");

		driver.findElement(By.id("signIn")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[text()='Pramit Koley']")).click();
		driver.switchTo().window(F);
				}
}
