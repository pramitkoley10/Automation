package Demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This code is created by Pramit koley.
		
		
		WebDriver Driver = new ChromeDriver();
		
		Driver.get("https://the-internet.herokuapp.com/");
		Driver.findElement(By.xpath("//div[@id='content']/ul/li/a[@href='/windows']")).click();
		Driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set<String> Windows = Driver.getWindowHandles();
		Iterator<String> n = Windows.iterator();
		String a=n.next();
		String b=n.next();
		Driver.switchTo().window(b);
		System.out.println(Driver.findElement(By.className("example")).getText());
		Driver.switchTo().window(a)	;
		System.out.println(Driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
