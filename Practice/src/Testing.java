
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Testing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		scroll(driver);
		screenshot(driver);
		
		
		brokenlink(driver);
		driver.close();
		

	}
	
	public static void scroll(WebDriver driver) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000)"," ");
		
		
	}
	
	public static void screenshot(WebDriver driver) throws IOException {
		TakesScreenshot scr = ((TakesScreenshot) driver);
		File pic = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File("/Users/pramitk/Desktop/Screenshot.jpg"));
		System.out.println("ScreenShot taken successfully");
		
	}
	
	public static void brokenlink(WebDriver driver) throws MalformedURLException, IOException {
		List<WebElement> links = driver.findElements(By.xpath("(//li[@class='gf-li'])/a"));
		
		for(WebElement link : links) {
			String a = link.getAttribute("href");
			HttpURLConnection url= (HttpURLConnection)new URL(a).openConnection();
			url.getRequestProperty("HEAD");
			url.connect();
			
			int resCode = url.getResponseCode();
			
			if(resCode>400) {
				System.out.println(link.getText()+" "+resCode+" - This is Broken LInk.");
			}else {
				System.out.println(link.getText()+" "+" - Test Pass");
			}
			
		}
		
		
		
	}
	

}
