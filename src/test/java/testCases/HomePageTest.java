package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FindAMeetingPage;
import pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	//FindAMeetingPage findMeetingPage;

	public HomePageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		homePage = new HomePage();
		
	}
	
	
	@Test 
	public void verifyPageTitleOf_home_page() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertTrue(actualTitle.contains("Weight Loss"));

	}
	

	
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
