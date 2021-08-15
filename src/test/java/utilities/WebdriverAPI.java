package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverAPI {
	
	public WebDriver driver;


	public WebElement expWaitForElement(WebDriver driver , int waitTime, String locator) {

		WebDriverWait wt = new WebDriverWait(driver, waitTime);
		WebElement ele = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return ele;
	}

	public void waitAndSendKeys(WebDriver driver , int waitTime, String locator, String value) {

		WebDriverWait wt = new WebDriverWait(driver, waitTime);
		WebElement ele = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		ele.sendKeys(value);


	}

	public void MaximizeWindow() {
		driver.manage().window().maximize();
	}

	public  void quickWait() throws Exception {
		Thread.sleep(3000);
	}

	public String createXpathWithText(String xpathValue) {

		String xpath = "//*[contains(text(),'"+xpathValue+"')]";
		return xpath;

	}

}
