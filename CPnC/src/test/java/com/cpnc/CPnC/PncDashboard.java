package com.cpnc.CPnC;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.ConnectionType;
import org.openqa.selenium.devtools.v123.network.model.Initiator;
import org.openqa.selenium.devtools.v123.network.model.Request;
import org.openqa.selenium.devtools.v123.network.model.Response;
import org.openqa.selenium.support.PageFactory;

public class PncDashboard {
	WebDriver driver;
	public PncDashboard(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pncBoard() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("newUserDefaultClose")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='companyList']/ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li/ul/li[1]/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul/li[4]/div/span[@class='itemName']")).click();
		Thread.sleep(2000);
		
		long start = System.currentTimeMillis();

		driver.findElement(By.xpath("//ul/li[2]/div/span[@class='itemName']")).click();

		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		Thread.sleep(5000);
		
		PncDashboard pd = new PncDashboard(driver);
		pd.emulatePageload();
		
		
		
		
		
	}
	
	public void emulatePageload() {
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
	    devTools.createSession();
	    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	    devTools.send(Network.emulateNetworkConditions(false,100,200000,100000,Optional.of(ConnectionType.ETHERNET)));
			
	  
	    
	    devTools.addListener(Network.requestWillBeSent(),
	            request -> {
	                Request req= request.getRequest();
	                if( req.getUrl().contains("getAllFeedbackData")) {
	                	
	                
	                System.out.println("Url - " + req.getUrl());
	           
	                }
	            });
	    long st = System.currentTimeMillis();
	    
	    long startTime = System.currentTimeMillis();
	    driver.findElement(By.xpath("//ul/li[2]/div/span[@class='itemName']")).click();
	    long endTime = System.currentTimeMillis();

	    System.out.println("Page loaded in " + (endTime - startTime) + " milliseconds");
	    
	    devTools.addListener(Network.responseReceived(),
	            response -> {
	                Response res= response.getResponse();
	                if( res.getUrl().contains("getAllFeedbackData")) {
	                	long et = System.currentTimeMillis();
	                System.out.println("Time - " + (et - st) + " milliseconds");
	                System.out.println("Url - " + res.getUrl());
	                System.out.println("Status - " + res.getStatus());
	                
	                }
	            });
	    
	}

}
