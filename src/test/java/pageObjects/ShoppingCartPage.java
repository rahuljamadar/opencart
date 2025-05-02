package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement btn_shoppingCart;
	
	@FindBy(xpath="//table[@class='table table-bordered']//td[@class='text-left']//a[contains(text(),'iPhone')]")
	WebElement productname;
	
	public void clickShoppingCart() {
		btn_shoppingCart.isDisplayed();
		btn_shoppingCart.click();
	}
	
	public boolean getProductName() {
		return productname.isDisplayed();
	}
	

}
