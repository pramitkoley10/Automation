package rahulshettyacademyShopping.website.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademyShopping.website.abstractcomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> items;
	@FindBy(css="[routerlink*='cart']")
	WebElement AddToCart;
	

	By itemsBy = By.cssSelector(".mb-3");
	By ToastContainerAppear = By.cssSelector("#toast-container");
	By ToastContainerDisappear = By.name("Product Added To Cart");
			
				
	
	public List<WebElement> getItemstList() {
		waitForElementToAppear(itemsBy);
		return items;
	}
	
	
	public WebElement getProductByName(String productname) {
		WebElement product = getItemstList().stream().filter(item->item.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return product;
	}
	
	public void addProductToCart(String productname) {
		getProductByName(productname).findElement(By.cssSelector(".btn.w-10.rounded:last-child")).click();
		waitForElementToAppear(ToastContainerAppear);
		waitForElementToDisappear(ToastContainerDisappear);
	}
	public AddToCartPage addToCart() {
		AddToCart.click();
		AddToCartPage AddToCartPage = new AddToCartPage(driver);
		return AddToCartPage;
	}
	
	
}
