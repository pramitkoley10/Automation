package rahulshettyacademyShopping.website.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademyShopping.website.abstractcomponents.AbstractComponents;

public class AddToCartPage extends AbstractComponents {
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

			
	@FindBy(css =".cartSection h3")
	List<WebElement> addtocartlists;
	
	@FindBy(css=".totalRow button")
	WebElement Checkout;
	
	@FindBy(css=".form-group input")
	WebElement Country;
	
	@FindBy(css=".actions a")
	WebElement PlaceOrder;
	
	
	By countrylist = By.cssSelector( "i.fa.fa-search");
	
	
	
	public boolean getVerifyAddToCartList(String productname) {
		boolean ans = addtocartlists.stream().anyMatch(addtocartlist->addtocartlist.getText().equalsIgnoreCase(productname));
		return ans;
	}
	
	public void getCheckoutButton() {
		Checkout.click();
	}
	
	public void getCountry() {
		Country.sendKeys("ind");
		waitForElementToAppear(countrylist);
		Actions a = new Actions(driver);
		a.scrollToElement(Country).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	
	public FinalPage getPlaceOrder() {
		PlaceOrder.click();
		FinalPage FinalPage = new FinalPage(driver);
		return FinalPage;
	}
	
	
	
}
