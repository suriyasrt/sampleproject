package UIverification;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mouseandkey {

	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void mosueactions() throws Exception {
	
		Actions action=new Actions(driver);
		
		action.keyDown(Keys.SHIFT).
		sendKeys("a").keyUp(Keys.SHIFT).
		build().perform();
		
		WebElement results=driver.findElement(By.id("result"));
		
		String testresult=results.getText();
		
		System.out.println(testresult);
		
		Assert.assertEquals(testresult.contains("A"), true);
		
		
	}
	
}
