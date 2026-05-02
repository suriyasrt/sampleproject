package UIverification;

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

public class fileupload {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void actions() throws Exception {
		
		WebElement file=driver.findElement(By.id("file-upload"));
		
		file.sendKeys("C:\\Users\\DELL\\Downloads\\Terminate_Grade_20260206052118.xlsx");
		
		Thread.sleep(4500);
		
		WebElement upload=driver.findElement(By.id("file-submit"));
		
		upload.click();
		
		
		WebElement fileuploaded=driver.findElement(By.xpath("//div[@id='content']/div/h3"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    	Assert.assertEquals(successmsg.getText(), "File Uploaded!");
		
		WebElement filename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
    	Assert.assertEquals(filename.getText(), "sampleimage.png");
		
		
	}
	
	@AfterTest
	public void teardown() {
		
	}


}
