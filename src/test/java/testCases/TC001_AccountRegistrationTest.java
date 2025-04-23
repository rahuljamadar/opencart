package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test()
	public void verify_account_registration() {
		
		logger.info("**** Started TC001_AccountRegistrationTest ****");
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**** Clicked on MyAccount link ****");
		hp.clickRegister();
		logger.info("**** Clicked on Register Link ****");
		
		AccountRegistrationPage repage= new AccountRegistrationPage(driver);
		
		logger.info("**** Providing customer details ****");
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"@gmail.com");
		repage.setPhone(randomNumber());
		
		repage.setPassword(randomAlpaNumeric());
		repage.setConfirmPassword(randomAlpaNumeric());
		
		repage.setPrivacyPolicy();
		repage.clickContinue();
		
		logger.info("**** Validating expected message ****");
		String msg=repage.getConfirmMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");	
		}
		catch(Exception e) {
			logger.error("Test failed");
			//logger.error("Debug logs");
			//Assert.fail();
			
			logger.info("**** Finish TC001_AccountRegistrationTest **** ");
		}
	}
	
}
