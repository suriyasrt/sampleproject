package UIverification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class multipledropdownselect {
	

	WebDriver driver;
	
	@BeforeTest
	public void beforelaunch() {
		
		driver=new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/basic-select-dropdown-demo.php");
		
		
	}
	
	@Test
	public void selectmultiple() throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement multiselect=driver.findElement(By.xpath("//select[@multiple='multiple']"));
		
		Select select=new Select(multiselect);
		
	    System.out.println("Verify it is Multiple"+ ""+select.isMultiple());
	    
	    
	    select.selectByVisibleText("Florida");
	    
	    select.selectByVisibleText("Texas");
	    
	    select.selectByVisibleText("Pennsylvania");
	    
	    
	    Thread.sleep(2500);
	    
	    select.deselectAll();
		
		
	}

}
