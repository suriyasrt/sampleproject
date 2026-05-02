package UIverification;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
	
	WebDriver driver;
	@BeforeTest
	public void launch() {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
	}
	@Test(priority=1)
	public void alerts() {
		
		WebElement onclick1=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		
		onclick1.click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		Assert.assertEquals("You successfully clicked an alert", "You successfully clicked an alert");
		
		
	
	}
	@Test(priority=2)
	public void alerts1() throws InterruptedException {
		
		Thread.sleep(4500);
		
WebElement onclick1=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		
		onclick1.click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		
	}
	
	@Test(priority=3)
	public void alerts2() throws InterruptedException {
		Thread.sleep(4500);
		
		WebElement onclick1=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		
		onclick1.click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.sendKeys("New Text");
		
		alert.accept();
				
	}

}
