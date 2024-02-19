package rahulshettyacademyShopping.website.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademyShopping.website.PageObjects.AddToCartPage;
import rahulshettyacademyShopping.website.PageObjects.FinalPage;
import rahulshettyacademyShopping.website.PageObjects.OrderHistry;
import rahulshettyacademyShopping.website.PageObjects.ProductCatalogue;
import rahulshettyacademyShopping.website.PageObjects.landingpage;
import rahulshettyacademyShopping.website.TestsComponent.BaseTest;

public class StandAloneTest2 extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub

		 

		landingpage landingpage =  lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata("Pramitkoley@mail.com", "Password@123");

		// main page

		String productname = ProductCatalogue.searchName();
		ProductCatalogue.getItemstList();
		ProductCatalogue.addProductToCart(productname);
		AddToCartPage AddToCartPage = ProductCatalogue.addToCart();

		// add to cart

		boolean ans = AddToCartPage.getVerifyAddToCartList(productname);
		AssertJUnit.assertTrue(ans);
		AddToCartPage.getCheckoutButton();

		// payment page

		AddToCartPage.getCountry();
		FinalPage FinalPage = AddToCartPage.getPlaceOrder();

		// final page

		String Thankyou = FinalPage.getThankYouStatus();
		AssertJUnit.assertTrue(Thankyou.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.close();

	}
	
	@Test(dependsOnMethods="submitOrder")
	public void orderHistry() throws IOException{
		
		landingpage landingpage =  lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata("Pramitkoley@mail.com", "Password@123");
		
		String productname = ProductCatalogue.searchName();
		
		OrderHistry OrderHistry = new OrderHistry(driver);
		OrderHistry.orderButton();
		Boolean ans = OrderHistry.orderProductList(productname);
		Assert.assertTrue(ans);
		driver.close();
		
	}
	

}
