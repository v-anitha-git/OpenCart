package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_006_RegistrationWithInvalidFields extends BaseClass {

		
	    @Test(priority=1)
	    public void testInvalidFirstName() {
	    	logger.info("*** Starting testInvalidFirstNameTest ***");
	    	try {
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        homePage.clickRegister();

	        RegistrationPage regPage = new RegistrationPage(driver);
	        regPage.setFirstname("019298388ddhfnchhzttehdfkklsieujfnhgjkajsj6"); // Invalid
	        regPage.setLastname(randomString().toLowerCase());
	        regPage.setEmail(randomString().toLowerCase() + "@gmail.com");
	        regPage.setPhoneNumber(randomNumber());
	        String pwd = randomAlphaNumeric();
	        regPage.setPassword(pwd);
	        regPage.setConfirmPassword(pwd);
	        regPage.setPrivacyPolicy();
	        regPage.clickContinue();

	        String errorMsg = regPage.getFieldErrorMessage();
	        Assert.assertTrue(errorMsg.contains("First Name must be between 1 and 32 characters!"));
	    	}
	    	catch(Exception e) {
	    		logger.error("Error in testInvalidFirstName: " + e.getMessage());
	    		Assert.fail("Test failed due to exception: " + e.getMessage());
	    	}
	    	catch(AssertionError e) {
	    		logger.error("Assertion error in testInvalidFirstName: " + e.getMessage());
	    		Assert.fail("Test failed due to assertion error: " + e.getMessage());
	    	}
	    	finally {
	    		logger.info("*** Finished testInvalidFirstNameTest ***");
	    	}
	    }
	    
	    

	    @Test(priority=2)
	    public void testInvalidLastName() {
	    	logger.info("*** Starting testInvalidLastNameTest ***");
	    	try {
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        homePage.clickRegister();

	        RegistrationPage regPage = new RegistrationPage(driver);
	        regPage.setFirstname(randomString());
	        regPage.setLastname("019292kfkfjgaddhfnchhzttehdfkklsij"); // Invalid
	        regPage.setEmail(randomString() + "@gmail.com");
	        regPage.setPhoneNumber(randomNumber());
	        String pwd = randomAlphaNumeric();
	        regPage.setPassword(pwd);
	        regPage.setConfirmPassword(pwd);
	        regPage.setPrivacyPolicy();
	        regPage.clickContinue();

	        String errorMsg = regPage.getFieldErrorMessage();
	        Assert.assertTrue(errorMsg.contains("Last Name must be between 1 and 32 characters!"));
	    	}
	    	catch(Exception e) {
	    		logger.error("Error in testInvalidLastName: " + e.getMessage());
	    		Assert.fail("Test failed due to exception: " + e.getMessage());
	    	}
	    	catch(AssertionError e) {
	    		logger.error("Assertion error in testInvalidLastName: " + e.getMessage());
	    		Assert.fail("Test failed due to assertion error: " + e.getMessage());
	    	}
	    	finally {
	    		logger.info("*** Finished testInvalidLastNameTest ***");
	    	}
	    }
	    
	    @Test(priority=3)
	    public void testInvalidEmail() {
	    	logger.info("*** Starting testInvalidEmailTest ***");
	    	try{
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        homePage.clickRegister();
	        
	        
	        RegistrationPage regPage = new RegistrationPage(driver);
	        
	        regPage.setFirstname(randomString());
	        regPage.setLastname(randomString());
	        regPage.setEmail("invalid-email@gmail"); // Invalid
	        regPage.setPhoneNumber(randomNumber());
	        String pwd = randomAlphaNumeric();
	        regPage.setPassword(pwd);
	        regPage.setConfirmPassword(pwd);
	        regPage.setPrivacyPolicy();
	        regPage.clickContinue();
	        setZoomLevel("50%");
	       
	        String errorMsg = regPage.getFieldErrorMessage();
	        Assert.assertTrue(errorMsg.contains("E-Mail Address does not appear to be valid!"));
	    	}
	    	catch(Exception e) {
	    		logger.error("Error in testInvalidEmail: " + e.getMessage());
	    		Assert.fail("Test failed due to exception: " + e.getMessage());
	    	}
	    	catch(AssertionError e) {
	    		logger.error("Assertion error in testInvalidEmail: " + e.getMessage());
	    		Assert.fail("Test failed due to assertion error: " + e.getMessage());
	    	}
	    	finally {
	    		logger.info("*** Finished testInvalidEmailTest ***");
	    	}
	    }

	    
	    @Test(priority=4)
	    public void testInvalidPassword() {
	    	logger.info("*** Starting testInvalidPasswordTest ***");
	    	try {
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        homePage.clickRegister();

	        RegistrationPage regPage = new RegistrationPage(driver);
	        regPage.setFirstname(randomString());
	        regPage.setLastname(randomString());
	        regPage.setEmail(randomString() + "@gmail.com");
	        regPage.setPhoneNumber(randomNumber());
	        regPage.setPassword("12"); // Invalid
	        regPage.setConfirmPassword("12");
	        regPage.setPrivacyPolicy();
	        regPage.clickContinue();
	        setZoomLevel("50%");

	        String errorMsg = regPage.getFieldErrorMessage();
	        Assert.assertTrue(errorMsg.contains("Password must be between 4 and 20 characters!"));
	    	}
	    	catch(Exception e) {
	    		logger.error("Error in testInvalidPassword: " + e.getMessage());
	    		Assert.fail("Test failed due to exception: " + e.getMessage());
	    	}
	    	catch(AssertionError e) {
	    		logger.error("Assertion error in testInvalidPassword: " + e.getMessage());
	    		Assert.fail("Test failed due to assertion error: " + e.getMessage());
	    	}
	    	finally {
	    		logger.info("*** Finished testInvalidPasswordTest ***");
	    	}
	    }
	    @Test(priority=5)
	    public void testInvalidPhoneNumber() {
	    	logger.info("*** Starting testInvalidPhoneNumberTest ***");
	    	try {
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        homePage.clickRegister();

	        RegistrationPage regPage = new RegistrationPage(driver);
	        regPage.setFirstname(randomString());
	        regPage.setLastname(randomString());
	        regPage.setEmail(randomString() + "@gmail.com");
	        regPage.setPhoneNumber("09"); // Invalid
	        String pwd = randomAlphaNumeric();
	        regPage.setPassword(pwd);
	        regPage.setConfirmPassword(pwd);
	        regPage.setPrivacyPolicy();
	        regPage.clickContinue();
	        setZoomLevel("50%");

	        String errorMsg = regPage.getFieldErrorMessage();
	        Assert.assertTrue(errorMsg.contains("Telephone must be between 3 and 32 characters!"));
	    	}
	    	catch(Exception e) {
	    		logger.error("Error in testInvalidPhoneNumber: " + e.getMessage());
	    		Assert.fail("Test failed due to exception: " + e.getMessage());
	    	}
	    	catch(AssertionError e) {
	    		logger.error("Assertion error in testInvalidPhoneNumber: " + e.getMessage());
	    		Assert.fail("Test failed due to assertion error: " + e.getMessage());
	    	}
	    	finally {
	    		logger.info("*** Finished testInvalidPhoneNumberTest ***");
	    	}
	    }
	    
}
