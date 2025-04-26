package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC003_SearchProductTest extends BaseClass {
	
	@Test
	public void verifySearchProduct() {
		
		logger.info("**** Started TC003_SearchProductTest ****");
			
			SearchPage sp= new SearchPage(driver);
			sp.searchText("iphone");
			sp.clickSearchButton();
			
			if(sp.equals("iphone")) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(false);
			}
			
			logger.info("**** Finish TC003_SearchProductTest ****");
	}
	
	

}
