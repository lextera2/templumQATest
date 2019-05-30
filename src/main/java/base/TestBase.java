package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		/**
		 * 	read the config file
		 * . means current dir, home
		 * 
		 * "/Users/lexterA/workspace2/webstoreselenium/src/main/java/webstoreselenium/qa/config/config.properties"
		 * */
		
		
		File src = new File("/Users/lexte/eclipse-workspace/templumQATest/src/main/java/config/config.properties");
		
		//C:\Users\lexte\eclipse-workspace\templumQATest\src\main\java\config\config.properties
		
		//\Users\lexter\eclipse-workspace\templumQATest\src\main\java\config\config.properties
		
		try{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
						
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void initialize(){
		//initialize browser
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}//
