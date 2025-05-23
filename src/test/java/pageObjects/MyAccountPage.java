package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msg_heading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btn_logout;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement btn_continue;
	
	public boolean isMyAccountExists() {
		try {
			return msg_heading.isDisplayed();
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void clickLogout() {
		btn_logout.click();
		btn_continue.click();
	}
	
	
}
