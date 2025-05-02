package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	@FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//i[@class='fa fa-check-circle']")
	WebElement successMsg;
	
	public void searchText(String name) {
		txtsearch.clear();
		txtsearch.sendKeys(name);
	}
	
	public void clickSearchButton() {
		btn_search.click();
	}
	
	public void clickAddToCart() {
		addToCart.isDisplayed();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);		
	    addToCart.click();
	}
	
	public boolean isAddToCartSuccessVisible() {
		return successMsg.isDisplayed();
	}
	
	
	

}
