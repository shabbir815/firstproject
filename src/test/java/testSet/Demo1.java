package testSet;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseConfig.Setup;

public class Demo1 extends Setup{


	@Test(priority = 2)
	public void getPageTittle() {
		test =report.createTest("getPageTittle");

		String PageTitle = driver.getTitle();
		System.out.println("Title is: "+PageTitle);
		test.log(Status.INFO, "The page tile is: "+PageTitle);

	}


	@Test(priority = 1,enabled = false)
	public void Test2() {
		System.out.println("Test 2,, NOTHING TO DO");
	}

	@Test
	public void Login() {
		test=report.createTest("Login to Google");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).click();
		
	}

	@Test(dependsOnMethods = "Login")
	public void Logout() {
		test=report.createTest("Logout From Google");
				

	}









}
