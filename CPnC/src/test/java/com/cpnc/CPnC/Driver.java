package com.cpnc.CPnC;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpnc.CPnCAddFeedback.AddFeedback;


public class Driver {
	public static WebDriver driver() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
       return driver;
	}
	@Test(dataProvider = "runTime")
	public static void login(int data) throws InterruptedException, IOException {
		
		AddFeedback af = new AddFeedback();
		af.numberOfApiCalls();
		
		WebDriver driver = driver();
		LoginPage loading = new LoginPage(driver);
		loading.loginPage();
		driver.close();
	}
	
	
	@DataProvider	
	public static Object[] runTime() {
		int n = 2;
		Object[] data = new Object[n];
		
		for(int i=0;i<=n-1;i++) {
			data[i] = i;
			
			
		}
		return data;
	}
	
	
}
