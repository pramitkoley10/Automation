package Cleversort.com.cleversort;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='New Widget']")).click();
		Thread.sleep(2000);
		
	
		driver.findElement(By.xpath("//div[@class='contentHeadingRightPart']/div/ul/li[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='createNewSecMainContent']//input")).sendKeys("TEST NEW");
		driver.findElement(By.xpath("//div[@class='createNewSecMainContent']//input")).sendKeys(Keys.ENTER);
//		driver.findElement(By.xpath("//div/div[@class=\"createNewSecMainContent\"]/div/div/div/div/span[@class='section-text-span']")).sendKeys("Test");
		
		
		
		System.out.println("completed");
		
		
//		
//		clickOn(btn_CreateNewWidget);
//		
//		WebElement widgetOpt = driver.findElement(By.xpath("//button[text()='New Widget']/following::ul[1]//li[text()='Task List']"));
//		clickOn(widgetOpt);
//		TestUtils.sleep(2000);
//
//@FindBy(xpath = "//button[text()='New Widget']")
//private WebElement btn_CreateNewWidget;
//
//backSpaceClear(txtb_SimpleTaskName_Header);
//	inputString(txtb_SimpleTaskName_Header, taskListName);
//	txtb_SimpleTaskName_Header.sendKeys( Keys.ENTER );
//	TestUtils.sleep(3000);

//@FindBy(xpath = "//div[@class='createNewSecMainContent']//input")
//private WebElement txtb_SimpleTaskName_Header;
//
//clickOn(btn_CreateNewWidget) = btn_CreateNewWidget.click();
//
//inputString(txtb_SimpleTaskName_Header, taskListName) = txtb_SimpleTaskName_Header.sendkeys(taskListName)
//
//TASK_LIST_NAME = TestUtils.getRandomString(5);
//		
		
//		
//		driver.findElement(By.xpath("//ul/li[2]/div/span[@class='itemName']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pncSection")));
    
	    Thread.sleep(10000);
	    
	    
	}

}
