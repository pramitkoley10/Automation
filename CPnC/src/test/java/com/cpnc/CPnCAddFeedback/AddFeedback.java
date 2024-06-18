package com.cpnc.CPnCAddFeedback;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddFeedback {
	//@Test(dataProvider="numberOfApiCalls")
	public void addFeedback(int number) {
		String path = System.getProperty("user.dir")+"//20240617121222631613.png";
		 File upload = new File(path);

//		 AddFeedback data = new AddFeedback();
		
		
//		
//		
//		Map<String,Object> jsonObjectPayload = new LinkedHashMap<>();
//		jsonObjectPayload.put("feedbackId", "0");
//		jsonObjectPayload.put("environmentKey", "FR0 73GfTAU m5vGnA QnYF/fbWuXskinAXHNzVgTTUZ 5rg3bEfsrJq/5WMp5gNTeIPYKRjs8dCqm85nPLCqQ==");
//		jsonObjectPayload.put("feedback", "Auto genarated");
//		jsonObjectPayload.put("pageUrl", "https://localhost.com/data/");
//		jsonObjectPayload.put("feedbackFile", upload);
//		jsonObjectPayload.put("pageTitle", "LocalHost");
//		jsonObjectPayload.put("userAgent", "userAgent");
//		jsonObjectPayload.put("browser", "Google Chrome version 125.0.0.0");
//		jsonObjectPayload.put("operatingSystem", "Windows 10.0");
//		jsonObjectPayload.put("screenWidth", "1417");
//		jsonObjectPayload.put("screenHeight", "911");
//		jsonObjectPayload.put("browserZoom", "135");
//		jsonObjectPayload.put("feedbackBy", "275");
//		jsonObjectPayload.put("feedbackCoordinates[top]", "78.37541163556531");
//		jsonObjectPayload.put("feedbackCoordinates[left]", "72.78571428571429");
//		jsonObjectPayload.put("feedbackCoordinates[width]", "16.857142857142858");
//		jsonObjectPayload.put("feedbackCoordinates[height]", "16.02634467618002");
//		jsonObjectPayload.put("feedbackStatusId", "1");
//		
//		
//
//		
//		Response resp1= RestAssured
//		.given()
//		.log()
//		.all()
//		.body(jsonObjectPayload)
//		.post("https://cleversort-qa-python-api-dot-cleversort-2023-qa.uc.r.appspot.com/saveFeedback");
//		System.out.println(resp1);
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		 int resp1 = RestAssured
			    .given()
			    .log()
			    .all()
			    .multiPart("feedbackFile", upload, "multipart/form-data") // Use multiPart for file upload
			    .formParam("feedbackId", "0")
			    .formParam("environmentKey", "FR0+73GfTAU+m5vGnA+QnYF/fbWuXskinAXHNzVgTTUZ+5rg3bEfsrJq/5WMp5gNTeIPYKRjs8dCqm85nPLCqQ==")
		        .formParam("feedback", "Auto genarated "+number)
		        .formParam("pageUrl", "https://localhost.com/data/")
		
		        .formParam("pageTitle", "LocalHost")
		        .formParam("userAgent", "userAgent")
		        .formParam("browser", "Google Chrome version 125.0.0.0")
		        .formParam("operatingSystem", "Windows 10.0")
		        .formParam("screenWidth", "1417")
		        .formParam("screenHeight", "911")
		        .formParam("browserZoom", "135")
		        .formParam("feedbackBy", "275")
		        .formParam("feedbackCoordinates[top]", "78.37541163556531")
		        .formParam("feedbackCoordinates[left]", "72.78571428571429")
		        .formParam("feedbackCoordinates[width]", "16.857142857142858")
		        .formParam("feedbackCoordinates[height]", "16.02634467618002")
		        .formParam("feedbackStatusId", "1")
			    // Add other form parameters here...
			    .post("https://cleversort-qa-python-api-dot-cleversort-2023-qa.uc.r.appspot.com/saveFeedback").statusCode();
			
		
		 System.out.println(resp1);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//@DataProvider
	
	public void numberOfApiCalls() {
		int n = 0;
		//Object[] data = new Object[n];
		
		for(int i=0;i<=n-1;i++) {
			//data[i] = i;
			AddFeedback af = new AddFeedback();
			af.addFeedback(i);
			
		}
		//return data;
	}
	
	
	
	
	
	
	
}


