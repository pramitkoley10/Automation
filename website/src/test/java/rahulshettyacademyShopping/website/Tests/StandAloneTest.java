package rahulshettyacademyShopping.website.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.WeakHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademyShopping.website.PageObjects.AddToCartPage;
import rahulshettyacademyShopping.website.PageObjects.FinalPage;
import rahulshettyacademyShopping.website.PageObjects.OrderHistry;
import rahulshettyacademyShopping.website.PageObjects.ProductCatalogue;
import rahulshettyacademyShopping.website.PageObjects.landingpage;
import rahulshettyacademyShopping.website.TestsComponent.BaseTest;
import rahulshettyacademyShopping.website.TestsComponent.Retry;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider = "getData", groups = "full test")
	public void submitOrder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub

		landingpage landingpage = lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata(input.get("username"), input.get("password"));

		boolean ans2 = landingpage.getIncorrectInput();
		if (ans2 == true) {
			driver.close();

		} else if (ans2 == false) {
			// main page

			// String productname = ProductCatalogue.searchName();
			String productname = input.get("productname");
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
	public void orderHistry(HashMap<String,String> input) throws IOException {

		landingpage landingpage = lunchApplication();
		ProductCatalogue ProductCatalogue = landingpage.logindata(input.get("username"), input.get("password"));

		boolean ans2 = landingpage.getIncorrectInput();
		if (ans2 == true) {
			driver.close();

		} else {

			OrderHistry OrderHistry = new OrderHistry(driver);
			OrderHistry.orderButton();
			Boolean ans = OrderHistry.orderProductList(input.get("productname"));
			Assert.assertTrue(ans);
			driver.close();
		}

	}
	@Test(groups="full test",retryAnalyzer=Retry.class)
	public void failTest() {
		
		Assert.assertTrue(false);
	}

//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "Pramitkoley@mail.com", "Password@123", "ADIDAS ORIGINAL" },
//				{ "Password@123", "Pramitkoley@mail.com", "IPHONE 13 PRO" } };
//
//	}
	
	@DataProvider
	public Object[][] getData() {
		 HashMap<String,String> map = new HashMap<String,String>();
			map.put("username", "Pramitkoley@mail.com");
			map.put("password", "Password@123");
			map.put("productname", "ADIDAS ORIGINAL");
			
		HashMap<String, String> map1 =new HashMap<String,String>();	
			map1.put("username", "Password@123");
			map1.put("password", "Pramitkoley@mail.com");
			map1.put("productname", "IPHONE 13 PRO");
			return new Object[][] {{map},{map1}};

	}
	
	

}
