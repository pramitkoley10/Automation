package com.cpnc.CPnC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
		 public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			 this.driver = driver;
				PageFactory.initElements(driver, this);
	}

		public void loginPage() throws InterruptedException, IOException {
		driver.get("https://qa.cleversort.com/org/8gg-wi/project/1/pnc/feedback-board");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pramit.koley@digitalavenues.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 PncDashboard pnc = new PncDashboard(driver);
		 pnc.pncBoard();
		 
	 }
		
		

}
