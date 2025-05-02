package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC003_AddProductToCartTest extends BaseClass {

	@Test
	public void verifyProductAddToCart() {

		logger.info("**** Started TC003_AddedProductToCartTest ****");
        ShoppingCartPage scart= new ShoppingCartPage(driver);
		SearchPage sp = new SearchPage(driver);
		sp.searchText("iphone");
		sp.clickSearchButton();

		if (sp.equals("iphone")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
		
		sp.clickAddToCart();
        Assert.assertTrue(sp.isAddToCartSuccessVisible(), "Success message not displayed");
        
        scart.clickShoppingCart();
        Assert.assertTrue(scart.getProductName(), "Product is not present in the cart");



		logger.info("**** Finish TC003_AddedProductToCartTest ****");
	}

}
