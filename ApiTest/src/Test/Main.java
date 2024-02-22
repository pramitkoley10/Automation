package Test;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Main {
	public static void main() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockurl), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
				devTools.addListener(Network.responseReceived(), response -> {
					Response res = response.getResponse();
					System.out.println(res.getUrl());
				});
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});

//	  driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//	  driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Api url = new Api(driver);
		url.data();

		Thread.sleep(2000);
		Assert.assertEquals("Oops only 1 Book available",
				driver.findElement(By.xpath("/html/body/app-root/app-library-dashboard/p")).getText());
		driver.close();
		
	}
	@Test
	public static void print() {
		
		System.out.println("222");
	
	}


}



	
