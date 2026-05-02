package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basepackage.BaseTest;
import utils.Excelutil;

public class saucelabLoginTest extends BaseTest{
	
	@Test
    public void loginTest() {
    	test = extent.createTest("Sauce Labs Login Test1");
        log.info("Starting Sauce Labs Login Test");
        // Read username, password from Excel
        String username = Excelutil.getCellData("Sheet1", 1, 0);
        String password = Excelutil.getCellData("Sheet1", 1, 1);
        log.info("Entering username");
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys(username);
        log.info("Entering password");
        // Enter password
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password);
        log.info("Clicking login button");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        // Validation
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        test.pass("Login successful");
        log.info("Login successful");
    }
    
    @Test
    public void sampletest1() {
    	test = extent.createTest("Sauce Labs Login Test2");
        log.info("Starting Sauce Labs Login Test");
        System.out.println("sample test case");
}


}
