package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FindAMeetingPage;
import pages.HomePage;

public class FindAMeetingPageTest extends TestBase{

	HomePage homePage;
	FindAMeetingPage findMeetingPage;

	public FindAMeetingPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		homePage = new HomePage();
		findMeetingPage= new FindAMeetingPage();
		
	}
	@Test
	public void verify_pageTitle_of_findAMeetinPage() {
		findMeetingPage = homePage.clickFindAStudio();
		String actualTitle = findMeetingPage.getPageTitle();
		Assert.assertTrue(actualTitle.contains("Meetings Near You"));
		 

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
