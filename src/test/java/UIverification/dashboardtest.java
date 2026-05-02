package UIverification;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basepackage.BaseTestlaunch;
import Pageobjects.DashboardPOJ;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Listeners;
import Basepackage.TestListener; //This line only tells Java compiler,This class exists, you can use it
@Listeners(TestListener.class) // Attach this Listener class to this test class, tells testng to execute it

public class dashboardtest extends BaseTestlaunch {
	
	
	DashboardPOJ test=new DashboardPOJ(driver);
	
	@Test(priority=0)
	public void loginTest() {
		DashboardPOJ test=new DashboardPOJ(driver);
		
		test.uname.sendKeys("standard_user");
		
		test.password.sendKeys("secret_sauce");
		
		test.login.click();
		
	}
	
    @Test (priority=1)
    public void verifyProductsAreDisplayedOnDashboard() throws InterruptedException 
    {
    	Thread.sleep(5000);
    	test = PageFactory.initElements(driver, DashboardPOJ.class);
    	
    	Assert.assertEquals(((List<WebElement>) test.addtocart).size(), 6);	
    	// Name, Price and Add cart button verify.
    	test.product.click();
    	//move to page object
    	if(test.name.isDisplayed()&& test.cart.isDisplayed()&&test.price.isDisplayed()) {
    		System.out.println("Name,Cart and Price listed");
    	}
    	else {
    		System.out.println("Name,Cart and Price not listed");
    	}  	
    }
    
    @Test(priority=2)
    public void verifyAddToCartUpdatesCartBadge() 
    {
    	test = PageFactory.initElements(driver, DashboardPOJ.class);
    	
    	test.addtocart.click();
    	
    	Assert.assertEquals(test.remove.getText(), "Remove");
    	
    	List<WebElement> value=driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
    	
         if(value.size()>0) {
        	 System.out.println("Item has added on Cart");
         }        
    }
    
    @Test(priority=3)
    public void verifyUserNavigatesToProductDetailsPage() 
    {
    	driver.navigate().back();
    	
    	test = PageFactory.initElements(driver, DashboardPOJ.class);
    	
    	WebElement productspage=driver.findElement(By.xpath("//*[@class='title']"));
    	
    	Assert.assertEquals(productspage.getText(), "Products");
    	  	
    }
    // add the count has increased and updating.
    
    @Test(priority=4)
    public void verifyDashboardUIElementsVisibility() 
    {
    	WebElement hamburgericon=driver.findElement(By.id("react-burger-menu-btn"));
    	
    	hamburgericon.isDisplayed();
    	
    	WebElement carticon=driver.findElement(By.id("shopping_cart_container"));
    	
    	carticon.isDisplayed();
    	
    	WebElement dropdown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    	
    	dropdown.isDisplayed();
    	
    	System.out.println(driver.getTitle());
    }
    // Extent report
    // property files 
    
    @Test(priority=5)
    public void sortingwithprice() {
    	
    	WebElement dropdownclick=driver.findElement(By.xpath("//span[@class='active_option']"));
    	dropdownclick.click();
    	
    	WebElement dropdown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    	Select selec=new Select(dropdown);
    	selec.selectByVisibleText("Price (low to high)");
    	
    	List <WebElement> price=driver.findElements(By.className("inventory_item_price"));
    	
    	List<Double> actualprices=new ArrayList<>();
    	
    	for(int i=0;i<price.size();i++) {
    		
    		String pricevalue=price.get(i).getText();
    		
    		pricevalue=pricevalue.replaceFirst("$", "");
    		
    		double prices=Double.parseDouble(pricevalue);
    		actualprices.add(prices);
    	}
    	
    	/*test = extent.createTest("Verify Sort By Price Low to High");
	    // Step 1: Select dropdown
	    WebElement dropdown = driver.findElement(By.className("product_sort_container"));
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("Price (low to high)");
	    // Step 2: Get all price elements
	    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
	    // Step 3: Store prices using for loop
	    List<Double> actualPrices = new ArrayList<>();

	    for (int i = 0; i < priceElements.size(); i++) .{
	        String priceText = priceElements.get(i).getText();   // "$29.99"
	        priceText = priceText.replace("$", "");              // "29.99"
	        double price = Double.parseDouble(priceText);        // 29.99
	        actualPrices.add(price);
	    }
	
	    
	    // Step 4: Sort copy list
	    List<Double> sortedPrices = new ArrayList<>(actualPrices);
	    Collections.sort(sortedPrices);

	    // Step 5: Compare
	    Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted low to high");
	    test.pass("Products sorted correctly (Low to High)");
	}*/
    }
    
   
    public void verifyLogoutloginissuccessful() 
    {
    	
    }

}

/*
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardPage {

    WebDriver driver;
    public dashboardPage(WebDriver driver){
        this.driver = driver;
    }
    //By in Selenium is a built-in class used to locate (find) elements on a webpage.
    //By is the locator (the address of the element).
    //WebElement is the actual element on the page.
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By addtocart = By.id("add-to-cart-sauce-labs-backpack");
    
    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
    
    public void addsaucelabsproducttocart(){
        driver.findElement(addtocart).click();
    }
    
}*/