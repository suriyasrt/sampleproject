package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iframeTest {
	
	WebDriver driver;
	
	@Test
	public void iframeswitch() throws Exception {
		
		driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/frames");
		
		Thread.sleep(3500);
		WebElement value1=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(value1);
		
      String textframe1=driver.findElement(By.id("sampleHeading")).getText();
		
		System.out.println("the value is : "+textframe1);
		
		Thread.sleep(3500);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3500);
		
		
		WebElement frame2=driver.findElement(By.id("frame2"));
		
		driver.switchTo().frame(frame2);
		
		String textframe2=driver.findElement(By.id("sampleHeading")).getText();
		
		System.out.println("the value is : "+textframe2);
		
		
		
		
		
	}

}
