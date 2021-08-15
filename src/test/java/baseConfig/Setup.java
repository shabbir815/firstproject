package baseConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.WebdriverAPI;

public class Setup extends WebdriverAPI {
	
	//public WebDriver driver;
	
	public static ExtentSparkReporter reproter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeSuite
	public void SetupReporter() {
		
		
		reproter = new ExtentSparkReporter("ExtentReports.html");
		reproter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(reproter);
		
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BrowserSetup() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver= new ChromeDriver();

		//NavigateToSite();
		//driver.get("https://www.amazon.com");
		
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBroswer(ITestResult Result ) {
		
		if(Result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Cases Passed");
		}
		else if(Result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed");
			test.log(Status.FAIL, Result.getThrowable());
		}
		
		driver.close();
		
	}
	
	@AfterSuite
	public void createReport() {
		report.flush();
	}
	
	public void NavigateToSite() {
		driver.get("https://www.amazon.com");
		
		if(driver.getTitle().contains("Amazon")) {
			//test.log(Status.INFO, "Successfully Navigated to Amazon Page");
		}
		else {
			test.log(Status.ERROR, "Unable to navigatye to Amazon");
		}
	}

	
	
	
	
}
