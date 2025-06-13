package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test
	public void verify_account_registration() {
		
		logger.info("*** started TC_001_AccountRegistrationPage ***");
		try {
			
		HomePage homepg=new HomePage(driver);
		logger.info("Clicked on MyAccount...");
		homepg.clickMyAccount();
		logger.info("Clicked on Register...");
		homepg.clickRegister();
		
		RegistrationPage regpg=new RegistrationPage(driver);

		logger.info("Providing customer details...");
		String fname=randomString().toLowerCase();
		String lname=randomString().toLowerCase();
		regpg.setFirstname(fname);
		regpg.setLastname(lname);
		regpg.setEmail(fname+"."+lname+"@gmail");
		regpg.setPhoneNumber(randomNumber());
		
		String pwd=randomAlphaNumeric();
		regpg.setPassword(pwd);
		regpg.setConfirmPassword(pwd);
		regpg.setNewsLetter();
		regpg.setPrivacyPolicy();
		Thread.sleep(15000); // wait for 2 seconds to ensure the checkbox is checked
		regpg.clickContinue();
		
		logger.info("Validating confirmation message...");
		String msg=regpg.getMessage();
		
		
		Assert.assertEquals(msg, "Your Account Has Been Created!", "Account registrtion failed. Actual message: " + msg);
		}		
		catch(Exception e) {
			logger.error("Exception occur: "+e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		catch(AssertionError e) {
			logger.error("Exception occurred: "+e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		finally {
			logger.info("*** finished TC_001_AccountRegistrationPage ***");
		}
	}	
}
