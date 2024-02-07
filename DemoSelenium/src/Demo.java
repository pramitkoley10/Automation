import org.openqa.selenium.By;
//import.org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import.org.openqa.selenium.chrome.ChromeOptions;
//import.org.openqa.selenium.remote.DesiredCapabilities;



public class Demo {

	public static void main(String[] args) throws InterruptedException {
		//.TODO.Auto-generated.method.stub
//		DesiredCapabilities.caps.=.new.DesiredCapabilities();
//		caps.setAcceptInsecureCerts(true);
//		ChromeOptions.options.=.new.ChromeOptions();
//		options.addArguments("disable-notificitions");
////		//options.merge(caps);
////		
//		options.setAcceptInsecureCerts(true);
//		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@value='Select Destination']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Kolkata')]")).click();
		
		//from.date.piker
		//driver.findElement(By.cssSelector("css-1dbjc4n.r-14lw9ot.r-11u4nky.r-z2wwpe.r-1phboty.r-rs99b7.r-1loqt21.r-13awgt0.r-ymttw5.r-5njf8e.r-1otgn73")).click();
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();

		//end.date.piker
		driver.findElement(By.cssSelector(".css-76zvg2.css-bfa6kz.r-homxoj.r-ubezar.r-icoktb")).click();

		int i=1;
		while(i<4){
			driver.findElement(By.xpath("(//*[name()='circle'])[5]")).click();
			Thread.sleep(1500);
			i++;
		}
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[8]/div[1]/div[3]/div[2]/div[5]/div[1]")).click();

		//passenger
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n'])[58]")).click();
		i=1;
		while(i<3){
		 driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-k8qxaj r-d9fdf6'] div:nth-child(1) div:nth-child(2) div:nth-child(3)")).click();
		 i++;
		}
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[id='react-root'] div[class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh'] div:nth-child(2) div:nth-child(2) div:nth-child(3)")).click();
		
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-z2wwpe.r-1loqt21.r-18u37iz.r-1777fci.r-d9fdf6.r-1w50u8q.r-ah5dr5.r-1otgn73")).click();

		Thread.sleep(1000);
		//currency
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[6]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'USD')]")).click();

		//student
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n'])[72]")).click();
		//submit
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-z2wwpe.r-1loqt21.r-18u37iz.r-1777fci.r-1g94qm0.r-d9fdf6.r-1w50u8q.r-ah5dr5.r-1otgn73")).click();

		System.out.println("ok ");

		
	}

}
