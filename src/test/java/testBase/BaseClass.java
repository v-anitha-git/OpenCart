package testBase;

import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	//@Parameters("browser")
	@BeforeClass
	public void setup() {		
		//Loading config.properties file
		/*
		FileReader file=new FileReader("./src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
		
		*/
		/*
		switch(br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case"firefox": driver=new FirefoxDriver();break;
			default:System.out.println("Invalid browser..");return;
		
		}
		*/
		driver=new ChromeDriver();
		logger=LogManager.getLogger(this.getClass());
		
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://tutorialsninja.com/demo/");
		//driver.get(properties.getProperty("appURL"));   //reading url from properties file
		driver.manage().window().maximize();
		
	}
		
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public String randomString() {
		String str=RandomStringUtils.randomAlphabetic(5);
		return str;
	}
	
	public String randomNumber() {
		String number=RandomStringUtils.randomNumeric(10);
		return number;
	}
	
	public String randomAlphaNumeric() {
		String str=RandomStringUtils.randomAlphanumeric(8,13);
		return str;
	}
	
	public void setZoomLevel(String zoomPercent) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("document.body.style.zoom = '" + zoomPercent + "'");
	}
	
	
}
	
