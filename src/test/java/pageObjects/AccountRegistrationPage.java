package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(id="input-firstname")
	WebElement txtfirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtlastname;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(id="input-confirm")
	WebElement txtconfirmpassword;

	@FindBy(xpath="//*input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//*input[@value='Continue']")
	WebElement contine;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String tele) {
		txtTelephone.sendKeys(tele);
	}
	
	public void setPassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void setConfirmPassword(String pass) {
		txtconfirmpassword.sendKeys(pass);
	}
	
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	
	public void clickContinue() {
		contine.click();
	}
	
	public String getConfirmMsg() {
		try {
		return (msgconfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
	
}
