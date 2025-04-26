package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BaseClass;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	public void searchText(String name) {
		txtsearch.clear();
		txtsearch.sendKeys(name);
	}
	
	public void clickSearchButton() {
		btn_search.click();
	}

}
