package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class StudioPage extends TestBase{

	public StudioPage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath= "//div[contains(@class,'currentday')]//div[@class='hours-list-item-hours']")  WebElement hours;
	
	public void printHours() {
		List<WebElement> hoursToday = driver.findElements(By.xpath("//div[contains(@class,'currentday')]//div[@class='hours-list-item-hours']"));
		
		for(WebElement hour:hoursToday) {
			System.out.println(hour.getText().trim());
			
			
		}
		 
	}
}
