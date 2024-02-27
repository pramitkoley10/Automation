package demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Testing {
	@Test
	public void getLocation() {
		ChromeOptions Options = new ChromeOptions();
		  Map < String, Object > prefs = new HashMap < String, Object > ();
		  Map < String, Object > profile = new HashMap < String, Object > ();
		  Map < String, Object > contentSettings = new HashMap < String, Object > ();

		    // SET CHROME OPTIONS
		    // 0 - Default, 1 - Allow, 2 - Block
		    contentSettings.put("geolocation", 2);
		    profile.put("managed_default_content_settings", contentSettings);
		    prefs.put("profile", profile);
		    Options.setExperimentalOption("prefs", prefs);
		//Options.addArguments("disable-geolocation");
		WebDriver driver = new ChromeDriver(Options);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/geolocation']")).click();
		
		contentSettings.replace("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    Options.setExperimentalOption("prefs", prefs);
	    
		driver.findElement(By.cssSelector("button")).click();
		
		//to block Alart massage same for notification and other.
		//Options.setExperimentalOption("geolocation", 2);
		driver.close();
	}
	

}
