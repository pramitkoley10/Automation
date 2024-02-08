package Assignment;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Practics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//This code is created by Pramit koley.
		
		
		WebDriver Driver =new ChromeDriver();
		Driver.manage().window().maximize();
		
		
		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");		
		Driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		
		
		WebElement a = Driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]"));
		
		
		
		Select dropdown = new Select(Driver.findElement(By.id("dropdown-class-example")));
		String text = a.getText();
		dropdown.selectByVisibleText(a.getText());
		WebElement b = Driver.findElement(By.xpath("(//input[@id='name'])[1]"));
		
		Actions act = new Actions(Driver);
		act.moveToElement(a).click().doubleClick().keyDown(Keys.COMMAND).sendKeys("c").build().perform();
		
	
		Thread.sleep(2000);
		act.moveToElement(b).click().keyDown(Keys.COMMAND).sendKeys("v").build().perform();
		

		Driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String[] p = Driver.switchTo().alert().getText().split(",");
		String[] q = p[0].split("  ");
		
		if (q[1].contains(text)) {
			
			System.out.println("Exist");
		}
		else {
			System.out.println("Not Exist");
			




		}
		

	}

}
