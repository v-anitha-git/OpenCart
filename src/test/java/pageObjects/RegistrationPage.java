package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_fname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_phone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_cfmPassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement radiobtn_subscribe;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_policy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement msg_error;
	@FindBy(xpath="//div[@class='text-danger']") WebElement msg_fname_error;
	
	
	public void setFirstname(String fname) {
		txt_fname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txt_lname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setPhoneNumber(String number) {
		txt_phone.sendKeys(number);
	}
	
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cfmpwd) {
		txt_cfmPassword.sendKeys(cfmpwd);
	}
	
	public void setNewsLetter() {
		radiobtn_subscribe.click();
	}
	
	public void setPrivacyPolicy() {
		chk_policy.click();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
	
	public String getMessage() {
		String message=msg.getText();
		return message;
	}
	
	public String getErrorMessage() {
		return msg_error.getText();
	}
	
	public String getFieldErrorMessage() {
		return msg_fname_error.getText();
	}

	
	
	
	
}
