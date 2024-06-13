import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Response;
import org.testng.annotations.Test;

//Test
public class Testcase extends Driver {
	static int p = 9;
	static String fileName;
	static String url;

	@Test
	public static void uploadFile() throws InterruptedException, MalformedURLException, IOException {
		
		Login_page login = loginBase();
		
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/div/div/div/aside/div/ul/li[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/aside/div/ul/li[5]/ul/li[3]")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Select date']")).click();
//		driver.findElement(By.xpath("//button[@type='button'][@class='ant-picker-header-prev-btn']")).click();
		
		driver.findElement(By.xpath("//*[text()='"+p+"']")).click();
		Testcase tc = new Testcase();
		File a1 = tc.data();
		//System.out.println(a1.getAbsolutePath());
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		Thread.sleep(2000);
		upload.sendKeys(a1.getAbsolutePath());
		
		
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.close();
		devTools.createSessionIfThereIsNotOne();
//		devTools.send(Log.enable());
//        devTools.send(Runtime.enable());
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), responseD -> {
			
			   url = responseD.getDocumentURL();
			   System.out.println(responseD.getDocumentURL());
			
			
//			System.out.println(res.getStatus());
		});
		
		
		 
		
				devTools.addListener(Network.responseReceived(), responseA -> {
					System.out.println(responseA.getResponse().getStatus());
					Response res = responseA.getResponse();
					
					if (res.getUrl().contains(url)) {
					   System.out.println(res.getStatus());
					}
//					System.out.println(res.getStatus());
				});
		
//		DevTools devTools = ((HasDevTools) driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
//		devTools.addListener(Network.requestWillBeSent(), request -> {
//			if (request.getRequest().getUrl().contains("2024-03-19")) {
//				
//				devTools.addListener(Network.responseReceived(), response -> {
//					Response res = response.getResponse();
//					System.out.println(devTools.send(Network.getResponseBody(response.getRequestId()))
//							.getBody());
//				});
//			} else {
//				System.out.println("Not a valid data");
//			}
//		});
		
		driver.findElement(By.xpath("//button[@type='button']/parent::form/child::button")).click();
		
		Thread.sleep(10000);
		

//		Thread.sleep(10000); // wait for traffic
//
		devTools.send(Network.disable());
//		devTools.close();
		
		driver.close();
	}
	
	public File data() {
//		File a1 = new File("//Users//pramitk//Desktop//DailyAttendanceLogsDetails 1.csv");
		File a1 = new File("//Users//pramitk//Desktop//2024-04-09.csv");
		String fileName1 = a1.getName();
		fileName = fileName1.split(".csv")[0];
//		System.out.println(fileName);
		
		return a1;
		
	}
//	@Test
//	@Test(dependsOnMethods = "uploadFile")
	public static void regularizationRequest() throws InterruptedException {
		Login_page login = loginBase();
		
		Thread.sleep(15000);
		
		Daily_Attendance Daily_Attendance = new Daily_Attendance();
		Daily_Attendance.dailyAttendancePage(driver,p);
		//Daily_Attendance.applyRegularizationRequest(driver);
	
	driver.close();
}
	
//	@Test
//	@Test(dependsOnMethods = "regularizationRequest")
	public static void regularizationApproving() throws InterruptedException {
       Login_page login = loginBase();
       
       Thread.sleep(15000);
       
       Regularization_Details Regularization_Details = new Regularization_Details();
       Regularization_Details.regularizationDetails(driver,fileName);
       
	}
	
	
	
}
