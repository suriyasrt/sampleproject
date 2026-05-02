package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void multiplebrowserlaunch(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		
		driver.get("https://www.google.com");
		System.out.println(browser + "Title is:" +driver.getTitle());
		driver.quit();
	}

}
