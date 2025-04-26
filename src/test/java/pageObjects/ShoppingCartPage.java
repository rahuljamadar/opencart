package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")
	WebElement btn_addcart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement cartitem;
	
	public void clickAddCart() {
		btn_addcart.isDisplayed();
		btn_addcart.click();
	}
	
	 public boolean isSuccessMessageDisplayed() {
	        return successMessage.isDisplayed();
	    }
	
	public String getCartQuantity() {
		return cartitem.getText();
	}

}
