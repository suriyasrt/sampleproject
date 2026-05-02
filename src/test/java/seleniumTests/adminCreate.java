package seleniumTests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basepackage.BaseTest;


public class adminCreate extends BaseTest {
	//protected static WebDriver driver;
	
@Test(priority=1)
	public void Loginandverifydashboard() throws InterruptedException {
	
	Thread.sleep(5000);
	
	 driver.findElement(By.name("username")).sendKeys("Admin");
	   
	   driver.findElement(By.name("password")).sendKeys("admin123");
	   
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
@Test (priority=2)
public void navigateToAdminModule() throws InterruptedException {	

	Thread.sleep(6000);
	

	driver.findElement(By.xpath("//*[text()='Admin']")).click();
	
	Thread.sleep(2000);
	
	
	
}

@Test(priority=3)	 
	public void addNewAdminUser() throws InterruptedException {
	
	Thread.sleep(6500);
	
    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    
    Thread.sleep(4500);
	
	driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]")).click();
	
	Thread.sleep(2500);
	
	driver.findElement(By.xpath("(//div[@role='listbox'])[1]")).click();
//	
//	Select select=new Select(dropdown);
//	
//	select.selectByValue("Admin");
	
	driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("as");
	
	Thread.sleep(9600);
	
	driver.findElement(By.xpath("//div[@role='listbox']//div[role='Rahul Das']"));
	
	Thread.sleep(3000);
//	
//Select select1=new Select(username);
//	
//	select1.selectByIndex(2);
	
	driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//div[@role='listbox'])[2]"));
	
//Select select2=new Select(staus);
//	
//	select2.selectByValue("Enabled");
	
	driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).sendKeys("suriya");
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Suriya@123");
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Suriya@123");
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	
	
	}

@Test(priority = 4)
public void verifyCreatedUser()
{
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Suriya");
	
	
	
}
@Test(priority = 5)
public void logoutApplication()
{
	
}



}

