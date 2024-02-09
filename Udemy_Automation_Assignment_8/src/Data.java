import java.awt.Desktop.Action;
import java.util.List;

import javax.swing.JList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Data {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//This code is created by Pramit koley.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@id='autocomplete']"))).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();		
		System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value"));
		

	}

}
