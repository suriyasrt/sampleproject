package Basepackage;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import Pageobjects.DashboardPOJ;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.configreader;

public  class BaseTestlaunch {

	protected  WebDriver driver;

	configreader config=new configreader();


	@BeforeTest
	public void setup() throws Exception
	{

		String browser=config.getBrowser();

		String url=config.getUrl();

		if(browser.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();    
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}

		//driver.manage().window().maximize();

		driver.get(url);

//		ChromeOptions options = new ChromeOptions();
//
//		Map<String, Object> prefs = new HashMap<>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		prefs.put("profile.password_manager_leak_detection", false);






	}

}
