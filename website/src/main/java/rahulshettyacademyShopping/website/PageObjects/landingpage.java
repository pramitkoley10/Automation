package rahulshettyacademyShopping.website.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademyShopping.website.abstractcomponents.AbstractComponents;

public class landingpage extends AbstractComponents {
	WebDriver driver;
	
	public landingpage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement WrongInputStatus;
	
	
	By FindBy = By.xpath("//div[@id='toast-container']");
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	public ProductCatalogue logindata(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		return ProductCatalogue;
	}
	
	public Boolean getIncorrectInput() {
		waitForElementToAppear(FindBy);
		Boolean ans = WrongInputStatus.getText().equalsIgnoreCase("Incorrect email or password.");
		return ans;
	}
	

}
