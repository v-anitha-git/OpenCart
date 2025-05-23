package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement in_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement in_pwd;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login; 
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement error_msg;
	
	public void setEmail(String email) {
		in_email.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		in_pwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public String getErrorMessage() {
		try {
			return error_msg.getText();
		}
		catch(Exception e) {
			return null;
		}
	}

}
