package rahulshettyacademyShopping.website.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademyShopping.website.PageObjects.AddToCartPage;
import rahulshettyacademyShopping.website.PageObjects.FinalPage;
import rahulshettyacademyShopping.website.PageObjects.ProductCatalogue;
import rahulshettyacademyShopping.website.PageObjects.landingpage;
import rahulshettyacademyShopping.website.TestsComponent.BaseTest;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub

		String productname = "ADIDAS ORIGINAL";

		landingpage landingpage =  lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata("Pramitkoley@mail.com", "Password@123");

		// main page

		ProductCatalogue.getItemstList();
		ProductCatalogue.addProductToCart(productname);
		AddToCartPage AddToCartPage = ProductCatalogue.addToCart();

		// add to cart

		boolean ans = AddToCartPage.getVerifyAddToCartList(productname);
		Assert.assertTrue(ans);
		AddToCartPage.getCheckoutButton();

		// payment page

		AddToCartPage.getCountry();
		FinalPage FinalPage = AddToCartPage.getPlaceOrder();

		// final page

		String Thankyou = FinalPage.getThankYouStatus();
		Assert.assertTrue(Thankyou.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.close();

	}

}
