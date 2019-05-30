package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class SearchResultPage extends TestBase {

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[contains(@href,'flatiron')]//span")  WebElement studioName;
	
	@FindBy(xpath= "//a[contains(@href,'flatiron')]//div[@ng-if='showDistance']")  WebElement distance;
	
	public String getStudioName() {
		return studioName.getText().trim();
	}
	
	public String getMiles() {
		return distance.getText().trim();
	}
	
	public StudioPage clikFirstStudio() {
		TestUtil.click(studioName);
		return new StudioPage();
	}
}
