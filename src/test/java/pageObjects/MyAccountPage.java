package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgeading;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountExists() {
		try {
			return (msgeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout() {
		logout.click();
	}

}
