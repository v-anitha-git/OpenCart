package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_008_SearchProductTest extends BaseClass {

	@Test(groups= {"Master"})
	public void verify_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_008_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			
			hm.clickSearch();
			Thread.sleep(5000);
			
			SearchPage sp=new SearchPage(driver);
			boolean status=sp.isProductExist("Mac");

			Assert.assertEquals(status,true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_008_SearchProductTest ");

	}
}
