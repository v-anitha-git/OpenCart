package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {
	
	public ExtentSparkReporter reporter;
	public ExtentReports report;
	public ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext context) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName="Test-Report-"+timeStamp+".html";
		
		reporter=new ExtentSparkReporter(".\\reports\\"+reportName);
		
		reporter.config().setDocumentTitle("OpenCart Automation Report");
		reporter.config().setReportName("OpenCart Functional reporting");
		reporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(reporter);
	}
	
	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getTestClass().getName());
		test.log(Status.PASS,result.getName()+" is Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = report.createTest(result.getTestClass().getName());
		
		test.log(Status.FAIL,result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			
			String imgPath = captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test=report.createTest(result.getClass().getName());
		test.log(Status.SKIP,result.getName()+" is Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	public String captureScreen(String tname) throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
