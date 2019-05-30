package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FindAMeetingPage;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchResultsPageTest  extends TestBase{

	HomePage homePage;
	FindAMeetingPage findMeetingPage;
	SearchResultPage searchResultPage;
	
	String zip = "10011";
	String expectedName = "WW Studio Flatiron";
	String expectedDistance = "0.49 mi.";

	public SearchResultsPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		homePage = new HomePage();
		findMeetingPage= new FindAMeetingPage();
		searchResultPage =  new SearchResultPage();
		
	}
	
	@Test
	public void verify_firstResult_studioName_and_distance() {
		findMeetingPage = homePage.clickFindAStudio();
		searchResultPage = findMeetingPage.enterZipCode(zip);
		String actualName = searchResultPage.getStudioName();
		String actualDistance = searchResultPage.getMiles();
		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualDistance, expectedDistance);
		System.out.println(searchResultPage.getMiles());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
