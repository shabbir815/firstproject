package baseConfig;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGAnnoS {
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("Before Suite");
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@BeforeTest
	void before() {
		
		System.out.println("oPENING bROWER");
		
	}
	
	@Test
	 void test1() {
		
		System.out.println("Test 1 Passed");
	}
	
	@Test
	 void test2() {
		System.out.println("Test 2 Passed");
	}
	
	@AfterTest
	void after() {
		System.out.println("Closing Broweser");
	}
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		
		System.out.println("After Method");
		
	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("After Suite");
	}

}
