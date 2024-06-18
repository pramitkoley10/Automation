package com.cpnc.CPnC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.devtools.v125.network.model.Request;
import org.openqa.selenium.devtools.v125.network.model.Response;
import org.openqa.selenium.support.PageFactory;

import com.cpnc.CPnC.TimesofRun.RunTime;

import ConsolFileReader.WriteIntoFile;

public class PncDashboard {
	WebDriver driver;
	public PncDashboard(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pncBoard() throws InterruptedException, IOException {
		Thread.sleep(10000);
//		driver.findElement(By.id("newUserDefaultClose")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='companyList']/ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li/ul/li[1]/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul/li[4]/div/span[@class='itemName']")).click();
		Thread.sleep(2000);
		
		
		
		PncDashboard pd = new PncDashboard(driver);
		pd.emulatePageload();
		
		
		
		
		
	}
	
	public void emulatePageload() throws InterruptedException, IOException {
		
		
		//WriteIntoFile list =new WriteIntoFile();
		ArrayList<String> list = new ArrayList<String>();
		
		
		
		long start = System.currentTimeMillis();

		driver.findElement(By.xpath("//ul/li[2]/div/span[@class='itemName']")).click();

		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		
		String a = "Total Time for page load - "+ Long.toString(totalTime);
		list.add(a);
		Thread.sleep(5000);
		
		
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
	    devTools.createSession();
	    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	   // devTools.send(Network.emulateNetworkConditions(false,100,200000,100000,Optional.of(ConnectionType.ETHERNET)));
			
	  
	    
	    devTools.addListener(Network.requestWillBeSent(),
	            request -> {
	                Request req= request.getRequest();
	                if( req.getUrl().contains("getAllFeedbackData")) {
	                	
	                
	                System.out.println("getAllFeedbackData Request send - " + req.getUrl().contains("https://api-qa.cleversort.com/api/v1/feedback/getAllFeedbackData"));
	           
	                Boolean b = req.getUrl().contains("https://api-qa.cleversort.com/api/v1/feedback/getAllFeedbackData");
	                String x="getAllFeedbackData Request send - " + String.valueOf(b);
	                list.add(x);
	                }
	            });
	    long st = System.currentTimeMillis();
	    
	    long startTime = System.currentTimeMillis();
	    driver.findElement(By.xpath("//ul/li[2]/div/span[@class='itemName']")).click();
	    long endTime = System.currentTimeMillis();

	    System.out.println("Page loaded in -" + (endTime - startTime) + " milliseconds");
	    
	    String y = "Page loaded in -"+ Long.toString(endTime - startTime);
		list.add(y);
	    
		
	   
	    
	    devTools.addListener(Network.responseReceived(),
	            response -> {
	                Response res= response.getResponse();
	                if( res.getUrl().contains("getAllFeedbackData")) {
	                	long et = System.currentTimeMillis();
	                	
	                	
	                	
	                System.out.println("ApiLoadTime - " + (et - st) + " milliseconds");
	                
	                String k = "ApiLoadTime - "+ Long.toString(et - st)+ " milliseconds";
	        		list.add(k);
	                
	                System.out.println("Url - " + res.getUrl());
	                
	                String l = "Url - "+ res.getUrl();
	        		list.add(l);
	                
	                System.out.println("Status - " + res.getStatus());
	                
	                String m = "Status - " + res.getStatus();
	        		list.add(m);
	                                
	                
	                
	                }
	            });
	    
	    Thread.sleep(10000);
	    WriteIntoFile list2 =new WriteIntoFile();
	    list2.writeText(list);
	    RunTime report = new RunTime();
	    report.createReport(list);
	}

}
