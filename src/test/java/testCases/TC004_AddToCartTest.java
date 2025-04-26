package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC004_AddToCartTest extends BaseClass {
	
	@Test
	public void verifyProductAddToCart() {
		
		logger.info("**** Started TC004_AddToCartTest ****");
		
		ShoppingCartPage sp= new ShoppingCartPage(driver);
		sp.clickAddCart();
		
		sp.isSuccessMessageDisplayed();
		Assert.assertTrue(sp.isSuccessMessageDisplayed(), "Success message not displayed after adding to cart");
		
		sp.getCartQuantity();
		String cartQty = sp.getCartQuantity(); // example: "(1)"
        Assert.assertTrue(cartQty.contains("1"), "Cart does not have 1 item after adding product.");
		
        System.out.println("iPhone successfully added to the cart!");
        
        logger.info("**** Finish TC004_AddToCartTest ****");
	}

}
