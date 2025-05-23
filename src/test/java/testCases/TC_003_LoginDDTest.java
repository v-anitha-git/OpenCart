package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import testBase.BaseClass;

import utilities.DataProviders;

public class TC_003_LoginDDTest extends BaseClass{
	
	
	@Test(dataProvider= "Logindata", dataProviderClass=DataProviders.class)
	public void verify_loginData(String email,String pwd,String expRes) {
		
		logger.info("*** Started TC_003_LoginDDTest ***");
		
		try {
		HomePage homepg=new HomePage(driver);
		logger.info("Clicked on MyAccount...");
		homepg.clickMyAccount();
		logger.info("Clicked on Login...");
		homepg.clickLogin();
		
		logger.info("entered login credentials...");
		LoginPage loginpg=new LoginPage(driver);
		loginpg.setEmail(email);
		loginpg.setPassword(pwd);
		loginpg.clickLogin();
		
		MyAccountPage myacctpg=new MyAccountPage(driver);
		boolean status=myacctpg.isMyAccountExists();
		
		// valid --> sucess -> test passed
		//           failure -> test failed
		// invalid --> sucess -> test failed
		//           failure -> test passed
		
		if(expRes.equalsIgnoreCase("valid")) {
			if(status) {
				myacctpg.clickLogout();
				logger.info("Test Passed...");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Test Failed...");
				Assert.assertTrue(false);
			}
		}
		else {
			if(status) {
				myacctpg.clickLogout();
				logger.info("Test Failed...");
				Assert.assertTrue(false);
			}
			else {
				logger.info("Test Passed...");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		finally {
		logger.info("*** Finished TC_003_LoginDDTest ***");
		}
	}
}
