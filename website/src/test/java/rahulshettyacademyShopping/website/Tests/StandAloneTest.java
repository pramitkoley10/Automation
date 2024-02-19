package rahulshettyacademyShopping.website.Tests;

import org.testng.annotations.DataProvider;
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

public class StandAloneTest extends BaseTest {

	@Test(dataProvider = "getData", groups = "full test")
	public void submitOrder(String username, String password, String productname) throws IOException {
		// TODO Auto-generated method stub

		landingpage landingpage = lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata(username, password);

		boolean ans2 = landingpage.getIncorrectInput();
		if (ans2 == true) {
			driver.close();

		} else if (ans2 == false) {
			// main page

			// String productname = ProductCatalogue.searchName();
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

	}

	@Test(dependsOnMethods = "submitOrder", dataProvider = "getData", groups = "full test")
	public void orderHistry(String username, String password, String productname) throws IOException {

		landingpage landingpage = lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata(username, password);

		boolean ans2 = landingpage.getIncorrectInput();
		if (ans2 == true) {
			driver.close();

		} else {

			OrderHistry OrderHistry = new OrderHistry(driver);
			OrderHistry.orderButton();
			Boolean ans = OrderHistry.orderProductList(productname);
			Assert.assertTrue(ans);
			driver.close();
		}

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Pramitkoley@mail.com", "Password@123", "ADIDAS ORIGINAL" },
				{ "Password@123", "Pramitkoley@mail.com", "IPHONE 13 PRO" } };

	}

}
