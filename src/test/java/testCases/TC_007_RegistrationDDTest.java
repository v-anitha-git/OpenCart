package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_007_RegistrationDDTest extends BaseClass{
	
	HomePage homePage;
	MyAccountPage myAccountPage;
	RegistrationPage regPage;
	
	@Test(dataProvider = "RegisterData", dataProviderClass = DataProviders.class)
	public void testRegistration(String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassword) {
		logger.info("*** Starting TC_007_RegistrationDDTest ***");
		
		try {
			homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickRegister();
			
			regPage = new RegistrationPage(driver);
			regPage.setFirstname(firstName);
			regPage.setLastname(lastName);
			regPage.setEmail(email);
			regPage.setPhoneNumber(phoneNumber);
			regPage.setPassword(password);
			regPage.setConfirmPassword(confirmPassword);
			regPage.setNewsLetter();
			regPage.setPrivacyPolicy();
			Thread.sleep(5000);
			regPage.clickContinue();
			setZoomLevel("50%");
			String errorMsg = regPage.getFieldErrorMessage();
			String alertmsg =regPage.getErrorMessage();	
			Assert.assertTrue(!errorMsg.equals("") || !alertmsg.equals(""), 
					"Test case failed... " + errorMsg + " or alert: " + alertmsg);
		} 
		catch (Exception e) {
				logger.error("Exception in TC_007_RegistrationDDTest: " + e.getMessage());		
		} 
		catch (AssertionError e) {
			String msg = regPage.getMessage();
			if(msg.equals("Your Account Has Been Created!")) {
				regPage.clickContinueAfterRegistration();
				myAccountPage = new MyAccountPage(driver);
				myAccountPage.clickLogout();
			}
				logger.error("Assertion in TC_007_RegistrationDDTest: " + e.getMessage());
				Assert.fail("Test failed due to assertion error: " + e.getMessage());
		}
		finally {
			logger.info("*** Finished TC_007_RegistrationDDTest ***");
		}
	}
}
