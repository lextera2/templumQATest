package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FindAMeetingPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.StudioPage;

public class StudioPageTest extends TestBase{
	HomePage homePage;
	FindAMeetingPage findMeetingPage;
	SearchResultPage searchResultPage;
	StudioPage studioPage;
	
	String zip = "10011";
	String expectedName = "WW Studio Flatiron";
	String expectedDistance = "0.49 mi.";

	public StudioPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		homePage = new HomePage();
		findMeetingPage= new FindAMeetingPage();
		searchResultPage =  new SearchResultPage();
		studioPage = new StudioPage();
		
		
	}
	@Test
	public void print_TODAYS_hours_of_operation() {
		findMeetingPage = homePage.clickFindAStudio();
		searchResultPage = findMeetingPage.enterZipCode(zip);
		studioPage = searchResultPage.clikFirstStudio();
		studioPage.printHours();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
