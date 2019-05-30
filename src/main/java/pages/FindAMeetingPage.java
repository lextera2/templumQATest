package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class FindAMeetingPage extends TestBase {
	public FindAMeetingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//input[@id='meetingSearch']
	
	@FindBy(id= "meetingSearch") WebElement enterZip;
	@FindBy(xpath= "//button[@class='btn spice-translated']")  WebElement arrowButton;
	

	
	public SearchResultPage enterZipCode(String zip) {

		TestUtil.clearAndSendKeys(enterZip, zip);
		TestUtil.click(arrowButton);
		//wait til url contains search
		return new SearchResultPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	

}
