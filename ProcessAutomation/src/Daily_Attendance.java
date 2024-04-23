import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Daily_Attendance {
	
	static int value1;
	static int value2;
	
	public void dailyAttendancePage(WebDriver driver, int p) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div/aside/div/ul/li[4]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/ul[1]/li[4]/ul[1]/li[1]/span[1]/a[1]")).click();
		
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[@aria-label='left']")).click();
//		Thread.sleep(3000);
		
		WebElement a = driver.findElement(By.xpath("//tbody"));
		for(int i=1;i<=5;i++) {
			WebElement b = a.findElement(By.xpath(".//tr["+i+"]"));
			for(int j=1;j<=7;j++) {
				WebElement c = b.findElement(By.xpath(".//td["+j+"]"));
				
				String s = c.findElement(By.xpath(".//div/div[@class='ant-picker-calendar-date-value']")).getText();
				int t =Integer.parseInt(s);
				int n=0;
				if(t==p) {
				 //boolean k = c.findElement(By.xpath(".//div/div/div/button")).isDisplayed();
				
//				try {
//					c.findElement(By.xpath(".//div/div/div/button/span")).isDisplayed();					
//					 n = 1;
//					 
//				    } catch (Exception e) {
//				      continue;
//				    }
				
					
			    	c.findElement(By.xpath(".//div/div/div/button")).click();
			    	Thread.sleep(3000);
			    	applyRegularizationRequest(driver,i,j);
			    	value1 = i;
			    	value2 = j;
			    
				
				}else {
					continue;
				}
				   
				
//			    if(n==1) {	
//			    	c.findElement(By.xpath(".//div/div/div/button")).click();
//			    	Thread.sleep(3000);
//			    	applyRegularizationRequest(driver,i,j);
//			    } else {
//			    	continue;
//			    }
		}
		
	}
	
	}
	public void applyRegularizationRequest(WebDriver driver, int i,int j) throws InterruptedException {
		Thread.sleep(3000);
		WebElement intime = driver.findElement(By.xpath("(//input[@placeholder='Select time'])[1]"));
//		intime.clear();
		intime.click();
		Thread.sleep(1000);
		String s = Keys.chord(Keys.COMMAND, "a");
	      intime.sendKeys(s);
	      // sending DELETE key
	      intime.sendKeys(Keys.DELETE);
		
		Thread.sleep(2000);
		intime.sendKeys("10:01 am");
		
		
		driver.findElement(By.xpath("//ul/li[2]/button")).click();
		
		
		
		WebElement Dropdown = driver.findElement(By.xpath("//input[@type='search']"));
		
		Dropdown.sendKeys("Forgot to Checkin");
		Dropdown.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//textarea[@class='ant-input']")).sendKeys(Integer.toString(i)+Integer.toString(j));
		
		driver.findElement(By.xpath("//button/span[normalize-space()='Submit']")).click();
		
	}
	
	
	public String discriptionValue() {
		String discriptionValue = Integer.toString(value1)+Integer.toString(value2);
		return discriptionValue;
	}

}
