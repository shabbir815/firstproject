package testSet;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseConfig.Setup;
import helpers.AmazonBasic;
import pageObject.Amazon_Homepage_Locators;

public class Amazon_Homepage_Test extends AmazonBasic {
	
	Amazon_Homepage_Locators loc = new Amazon_Homepage_Locators();
	
	@Test(groups = {"TC"})
	public void Amazon_Search_bar_001() {
		test=report.createTest("Amazon_Search_bar_001");
		
		NavigateToSite();
		
		WebElement searchBar = expWaitForElement(driver, 10, loc.azSearchBar);
		if(searchBar.isDisplayed()==true) {
			test.log(Status.INFO, "Amzon search bar is displayed");
		}
		else {
			test.log(Status.ERROR, "Amzon search bar is NOT displayed");
		}
		
		
		WebElement searchButton = expWaitForElement(driver, 10, loc.azSearchButtton);
		if(searchButton.isDisplayed()==true) {
			test.log(Status.INFO, "Amzon search button is displayed");
		}
		else {
			test.log(Status.ERROR, "Amzon search button is NOT displayed");
		}
		
		String searchValue = "Iphone x";
		searchBar.sendKeys(searchValue);
		test.log(Status.INFO, "Ectered " +searchValue+ " in the search bar");
		
		searchButton.click();
		test.log(Status.INFO, "Clicked on the search button");
		
		try {
			
			WebElement resultHeader = expWaitForElement(driver, 10, loc.resultHeader);quickWait();
			String serahVal_Resultapge = resultHeader.getText();
			test.log(Status.INFO, "Test displayed on search result page is: "+serahVal_Resultapge);
			if(serahVal_Resultapge.contains(searchValue)) {
				test.log(Status.INFO, "Proper search result page is loaded");
			}
			else {
				test.log(Status.ERROR,  "Unexpected search result page is loaded");
			}
			
		} catch (Exception e) {
			test.log(Status.ERROR, "Unable to load search result page");
		}
		
		
		
	}

}
