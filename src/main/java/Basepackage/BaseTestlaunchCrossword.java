package Basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import utils.configreader;

public class BaseTestlaunchCrossword {
	
	protected WebDriver driver;
	
	configreader config=new configreader();
	
	@BeforeTest
	public void setup() {
		
		String browser=config.getBrowser();
		
		String url=config.getUrl();
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver =new FirefoxDriver();
		}
		
		
		driver.navigate().to(url);
		
		
	}

}
