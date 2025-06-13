package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnk_MyAcct;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnk_Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnk_login;
	
	@FindBy(xpath="//input[@placeholder='Search']")  WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") WebElement btnSearch;
	
	public void clickMyAccount() {
		lnk_MyAcct.click();
	}
	
	public void clickRegister() {
		lnk_Register.click();
	}
	
	public void clickLogin() {
		lnk_login.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
}
