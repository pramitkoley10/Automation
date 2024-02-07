import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// This code is created by Pramit koley.
		
		
		WebDriver Driver = new ChromeDriver();
		
		Driver.get("https://the-internet.herokuapp.com/");
		Driver.findElement(By.xpath("//div[@id='content']/ul/li/a[@href='/nested_frames']")).click();
		//Driver.switchTo().frame(Driver.findElement(By.xpath("//html//frameset")));
		Driver.switchTo().frame(Driver.findElement(By.xpath("//frame[@name='frame-top']")));
		Driver.switchTo().frame(Driver.findElement(By.name("frame-middle")));
		String k = Driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(k);
	
	
	}

}
