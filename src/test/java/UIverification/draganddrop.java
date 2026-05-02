package UIverification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class draganddrop {

	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.get("");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void actions() throws Exception {
		
		
	}
	
	@AfterTest
	public void teardown() {
		
	}


}
