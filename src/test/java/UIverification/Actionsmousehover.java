package UIverification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actionsmousehover {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/hovers");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void actions() throws Exception {
		
		WebElement img=driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
		
		WebElement profile=driver.findElement(By.xpath("(//*[contains(text(),'View profile')])[1]"));
		
		Actions action=new Actions(driver);
		
	action.moveToElement(img).perform();
		
		Thread.sleep(5000);
		
		profile.click();
	}
	
	@AfterTest
	public void teardown() {
		
	}

}
