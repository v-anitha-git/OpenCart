package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test	
	public void verify_login_credentials() {
		
		logger.info("*** Started TC_002_LoginTest ***");
		
		HomePage homepg=new HomePage(driver);
		logger.info("Clicked on MyAccount...");
		homepg.clickMyAccount();
		logger.info("Clicked on Login...");
		homepg.clickLogin();
		
		logger.info("entered login credentials...");
		LoginPage loginpg=new LoginPage(driver);
		loginpg.setEmail("keerthi@gmail.com");
		loginpg.setPassword("Keerthi");
		loginpg.clickLogin();
		String errormsg=loginpg.getErrorMessage();
		
		MyAccountPage myacctpg=new MyAccountPage(driver);
		boolean status=myacctpg.isMyAccountExists();

		if(status) {
			logger.info("Login is successful...");
			myacctpg.clickLogout();
			Assert.assertTrue(true);
		}
		else {
			logger.error("Login is failed...");
			Assert.assertFalse(true, "Login failed... " +errormsg);
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
	}

}
