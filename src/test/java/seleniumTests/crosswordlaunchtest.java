package seleniumTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import Basepackage.BaseTestlaunchCrossword;
import Pageobjects.crossWordPOJ;

public class crosswordlaunchtest extends BaseTestlaunchCrossword {
	
	
	
	@Test(priority=1,enabled=true,description="Search the word manifest")
	public void searchmanifest() {
		
	crossWordPOJ test=PageFactory.initElements(driver, crossWordPOJ.class);
		
	test.search.sendKeys("manifest");
		
	}
	
	@Test(priority=2,enabled=true,description="Choose the viewmore button")
	public void clickonviewmore() throws InterruptedException {
		
		Thread.sleep(7000);
		
		crossWordPOJ test=PageFactory.initElements(driver, crossWordPOJ.class);
		
		JavascriptExecutor execute=(JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(true)", test.viewmore);
		
		test.viewmore.click();
		
		
	}
	
	
	@Test(priority=3,enabled=true,description="Sort from low to high")
	public void sortbylowtohigh() throws Exception {
		crossWordPOJ test=PageFactory.initElements(driver, crossWordPOJ.class);
		
		Thread.sleep(15500);
		
		test.sortby.click();
		
		Select select=new Select(test.selectoption);
		
		select.selectByVisibleText("            Price: Low to High    ");
		
		
	}
	
	

}

/*
 * public class crosswordsiteTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.crossword.in/");
    }

    @Test(priority = 1,enabled=true,description="search for the text manifest")
    public void searchBook() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("manifest");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("manifest"));
    }

    @Test(priority = 2,enabled=true,description="sort By LowToHigh")
    public void sortByLowToHigh() throws InterruptedException {

        WebElement sortDropdown = driver.findElement(By.className("wizzy-common-select-selector"));
        sortDropdown.click();
        WebElement sortOption = driver.findElement(
        	    By.xpath("//div[normalize-space()='Price: Low to High']")
        	);
        sortOption.click();
        Thread.sleep(5000);
        List<WebElement> priceElements =
                driver.findElements(By.xpath("//p[@class='product-item-original-price']"));

        List<Double> actualPrices = new ArrayList<>();

     // NORMAL FOR LOOP
     for (int i = 0; i < priceElements.size(); i++) {

         String text = priceElements.get(i).getText();

         text = text.replace("₹", "").replace(",", "").trim();

         actualPrices.add(Double.parseDouble(text));
     }

     List<Double> sortedPrices = new ArrayList<>(actualPrices);
     Collections.sort(sortedPrices);
     Assert.assertEquals(actualPrices, sortedPrices);


    }
 */
 
