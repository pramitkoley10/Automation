package rahulshettyacademyShopping.website.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
	WebDriver driver;
	
	public landingpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	public  void logindata(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		submit.click();
	}
	

}
