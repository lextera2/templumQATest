package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class HomePage extends TestBase {

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@id='ela-menu-visitor-desktop-supplementa_find-a-studio']") public WebElement findAStudio;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public FindAMeetingPage clickFindAStudio() {
		//click find a studio
		TestUtil.click(findAStudio);
		
		return new FindAMeetingPage();
	}
}

