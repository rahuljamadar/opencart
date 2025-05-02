package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test()
	public void verify_Login() {
		
		logger.info("**** Starting TC002_LogintTest ****");
		
		try {
		HomePage hp= new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginBtn();
		
		MyAccountPage mp= new MyAccountPage(driver);
		boolean targetvalue =mp.isMyAccountExists();
		
		Assert.assertEquals(targetvalue,true, "Login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finish TC002_LogintTest ****");
	}
	
	

}
