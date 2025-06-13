package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_004_AccountRegistrationWithEmptyFieldsTest extends BaseClass{

	@Test
	public void verify_registration_emptyData() {
		logger.info("*** started TC_004_AccountRegistrationWithEmptyFieldsTest ***");
		try {
		HomePage homepg=new HomePage(driver);
		homepg.clickMyAccount();
		homepg.clickRegister();
		
		RegistrationPage regpg=new RegistrationPage(driver);
		regpg.setFirstname("");
		regpg.setLastname("");
		regpg.setEmail("");
		regpg.setPhoneNumber("");
		regpg.setPassword("");
		regpg.setConfirmPassword("");
		regpg.clickContinue();
		
		String errormsg=regpg.getErrorMessage();
		
		Assert.assertEquals(errormsg, "Warning: You must agree to the Privacy Policy!","Test Failed..."+errormsg);
		}
		catch(Exception e) {
			logger.error("Exception occured: "+e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		catch(AssertionError e) {
			logger.error("Exception occured: "+e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		finally {
			logger.info("*** finished TC_004_AccountRegistrationWithEmptyFieldsTest ***");
		}
}
}
