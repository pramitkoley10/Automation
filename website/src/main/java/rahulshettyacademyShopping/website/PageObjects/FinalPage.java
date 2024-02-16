package rahulshettyacademyShopping.website.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademyShopping.website.abstractcomponents.AbstractComponents;

public class FinalPage extends AbstractComponents {
	WebDriver driver;
	
	public FinalPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement thankyoutext;

	
	public String getThankYouStatus() {
		String Thankyou = thankyoutext.getText();
		return Thankyou;
	}
	
}
