package seleniumTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.Loginpage;

public class logintest {
	
	WebDriver driver;
	
	Loginpage login=new Loginpage(driver);
	
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

@Test(priority=1)
public void verifyLoginPageTitle() throws InterruptedException {
	
	Thread.sleep(5000);
	
	String actualtitle=driver.getTitle();
	
	Assert.assertEquals(actualtitle, "OrangeHRM", "The title is received");
	}

    @Test(priority=2)
	public void verifyLoginPageSourceDoesNotContainError(){
    	
    	Assert.assertFalse(driver.getPageSource().contains("404") || driver.getPageSource().contains("500"), "Page is not contains 404");
		
	}
    

   @Test(priority=4)
	public void verifyLoginWithValidCredentials() throws Exception{
	   
	   Thread.sleep(8500);

//	   driver.findElement(By.name("username")).sendKeys("Admin");
//	   
//	   driver.findElement(By.name("password")).sendKeys("admin123");
//	   
//	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   
	   login.enterusername("Admin");
	   
	   login.enterpasssword("admin123");
	   
	   login.clickloginbtn();
	   
	   
	   Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Logged into the Dashboard page");
		
	}

   @Test(priority=3)
	public void verifyErrorMessageForInvalidLogin() throws InterruptedException{
	   
	   driver.findElement(By.name("username")).sendKeys("adinsadf");
	   
	   driver.findElement(By.name("password")).sendKeys("342342");
	   
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
	   
	 //  driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed();
	   
	  //21 Thread.sleep(5000);
		
	}
   
   @Test(priority = 5)
   public void verifyLoginFieldPlaceholders() {

       String usernamePlaceholder =
               driver.findElement(By.name("username")).getAttribute("placeholder");
       String passwordPlaceholder =
               driver.findElement(By.name("password")).getAttribute("placeholder");

       Assert.assertEquals(usernamePlaceholder, "Username", "Username placeholder is incorrect");
       Assert.assertEquals(passwordPlaceholder, "Password", "Password placeholder is incorrect");
   }

   @Test(priority=5)
   public void passwordmasked() {
	   
	  String pass= driver.findElement(By.name("password")).getAttribute("Password");
	  
	  Assert.assertEquals(pass, "password", "Password is masked");
   }
   
   @AfterTest
   public void quitbrowser() {
	   
   }

}
