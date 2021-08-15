package helpers;

import com.aventstack.extentreports.Status;

import baseConfig.Setup;
import testSet.Amazon_Homepage_Test;

public class AmazonBasic extends Setup {
	
	public void NavigateToSite() {
		driver.get("https://www.amazon.com");
		
		if(driver.getTitle().contains("Amazon")) {
			test.log(Status.INFO, "Successfully Navigated to Amazon Page");
		}
		else {
			test.log(Status.ERROR, "Unable to navigatye to Amazon");
		}
	}


}
