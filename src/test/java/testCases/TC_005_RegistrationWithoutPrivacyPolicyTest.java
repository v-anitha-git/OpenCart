package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_005_RegistrationWithoutPrivacyPolicyTest extends BaseClass {

	@Test
	public void verify_registration_without_policy() {
		logger.info("*** started TC_005_RegistrationWithoutPrivacyPolicyTest ***");
		try {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickRegister();
		
		RegistrationPage regPage = new RegistrationPage(driver);
		String fname=randomString().toLowerCase();
		String lname=randomString().toLowerCase();
		regPage.setFirstname(fname);
		regPage.setLastname(lname);
		regPage.setEmail(fname+"."+lname+"@gmail.com");
		regPage.setPhoneNumber(randomNumber());
		String pwd=randomString();
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);
		regPage.setNewsLetter();
		Thread.sleep(5000);
		regPage.clickContinue();

		String errorMsg = regPage.getErrorMessage();
		Assert.assertTrue(errorMsg.contains("Warning: You must agree to the Privacy Policy!"));
		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			logger.info("*** finished TC_005_RegistrationWithoutPrivacyPolicyTest ***");
		}
	}
       
}

