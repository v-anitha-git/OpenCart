package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;


public class TC_009_AddToCartPageTest extends BaseClass {
	
	@Test(groups= {"Master"})
	public void verify_addToCart() throws InterruptedException {
		logger.info(" Starting TC_009_AddToCartPageTest ");

		try {
			
			HomePage hp=new HomePage(driver);
			
			hp.enterProductName("iPhone");
			hp.clickSearch();
			
						
			SearchPage sp=new SearchPage(driver);
			
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();
				Thread.sleep(5000); // Wait for confirmation message to appear
			}
						
			Assert.assertEquals(sp.checkConfMsg(),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_009_AddToCartPageTest ");

	}
}
