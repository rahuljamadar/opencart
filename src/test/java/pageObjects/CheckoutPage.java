package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//span[normalize-space()='Checkout']")
	WebElement btn_checkout;
	
	
	public void clickCheckout() {
		btn_checkout.isDisplayed();
		btn_checkout.click();
	}

}
