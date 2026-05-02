package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exceptionhandling {
	WebDriver driver;
	@BeforeTest
	public void browsersetup() {
		driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	}
	
	@Test
	public void exceptiontest1() throws InterruptedException {
		
		Thread.sleep(4500);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
		
	WebElement deletebtn=	driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
	
	deletebtn.isDisplayed();
		
	}
	
	@Test(priority=2)
	public void exceptiontest2() throws Exception {
		
		Thread.sleep(4500);
		
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		
		
	}

}
