package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;	
	}
	
By username=By.name("username");
By password=By.name("password");
By Loginbutton=By.xpath("//button[@type='submit']");

public void enterusername(String uname) {
	
	driver.findElement(username).sendKeys(uname);
}

public void enterpasssword(String pwd) {
	
	driver.findElement(username).sendKeys(pwd);
}

public void clickloginbtn( ) {
	
	driver.findElement(Loginbutton).click();
}

}



//public Loginpage(WebDriver driver) {
//	this.driver=driver;
//}
//
//By username = By.name("username");  
//By password = By.name("password");
//By Loginbutton = By.xpath("//button[@type='submit']");
//
//public void enterusername(String uname)
//{	
//driver.findElement(username).sendKeys(uname);
//}
//
//public void enterpassword(String pwd)
//{
//driver.findElement(password).sendKeys(pwd);
//}
//
//public void clicklogin()
//{
//driver.findElement(Loginbutton).click();
//}
//
//
