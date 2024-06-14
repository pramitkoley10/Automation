package com.cpnc.CPnC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Driver {
	public static WebDriver driver() {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
       return driver;
	}
	@Test
	public static void login() throws InterruptedException {
		WebDriver driver = driver();
		LoginPage loading = new LoginPage(driver);
		loading.loginPage();
		
	}
}
