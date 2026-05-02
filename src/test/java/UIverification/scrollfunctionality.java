package UIverification;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class scrollfunctionality {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/documentation/webdriver/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void scrolloption() throws Exception {
		
		Thread.sleep(3500);
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		WebElement scroll=driver.findElement(By.xpath("//a[contains(text(),'Browser interactions')]"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);", scroll);

		Thread.sleep(3500);
	}
	
	@Test(priority=2)
	public void scrollbypixel() throws Exception {
	Thread.sleep(3500);
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollBy(0,500)"); // downwards scroll.
		
		
	}
	@Test(priority=3)
	public void scrolltobottom() throws InterruptedException {
		
        Thread.sleep(3500);
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

}
