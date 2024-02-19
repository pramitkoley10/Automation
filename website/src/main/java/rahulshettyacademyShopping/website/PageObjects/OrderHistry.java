package rahulshettyacademyShopping.website.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademyShopping.website.abstractcomponents.AbstractComponents;

public class OrderHistry extends AbstractComponents{
	WebDriver driver;
	public OrderHistry(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> ProductNames;
	
	public boolean orderProductList(String item) {
		boolean ans = ProductNames.stream().allMatch(ProductName->ProductName.getText().equalsIgnoreCase(item));
		
		return ans;
	}

}
