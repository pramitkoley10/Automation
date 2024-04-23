import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Regularization_Details {

	public void regularizationDetails(WebDriver driver, String fileName) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div/aside/div/ul/li[4]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//a[normalize-space()='Regularization Details'])[1]")).click();
		Thread.sleep(4000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		int count = rows.size();
		
		
		Daily_Attendance Daily_Attendance = new Daily_Attendance();
		String discriptionValue = Daily_Attendance.discriptionValue();
		
		WebElement a = driver.findElement(By.xpath("//tbody"));
		for(int i=1;i<=count;i++) {
			WebElement b = a.findElement(By.xpath(".//tr["+i+"]"));
//			for(int j=1;j<=7;j++) {
//				WebElement c = b.findElement(By.xpath(".//td["+j+"]"));
			if( b.findElement(By.xpath(".//td[1]")).getText().equals("Pramit Koley") && b.findElement(By.xpath(".//td[6]")).getText().equals(discriptionValue) &&  b.findElement(By.xpath(".//td[2]")).getText().equals(fileName) ) {
				Random random = new Random();
				int ranData = random.nextInt(2)+1;
				if(ranData == 1) {
					b.findElement(By.xpath(".//td[7]/span[1]/div[1]/button["+ranData+"]")).click();
				}else {
					b.findElement(By.xpath(".//td[7]/span[1]/div[1]/button["+ranData+"]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//textarea[@placeholder='Reason for rejection']")).sendKeys(discriptionValue);
					driver.findElement(By.xpath("//button/span[normalize-space()='Submit']")).click();
				}
			}
		}		
				
	}
	
	
}
