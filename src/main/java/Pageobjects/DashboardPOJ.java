package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOJ {
	
	WebDriver driver;
	
	public DashboardPOJ(WebDriver driver) {
		
	this.driver=driver;
	
	}
	
	@FindBy(id="user-name")
	public WebElement uname;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement login;
	
	@FindBy(id="inventory_item_description")
	public WebElement itemdescription;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	public WebElement addtocart;
	
	@FindBy(xpath="(//button[contains(text(),'Add to cart')])[1]")
	public WebElement addtocart1;

	@FindBy(xpath="(//div[@class='inventory_item_name '])[1]")
	public WebElement product;
	
	@FindBy(id="remove")
	public WebElement remove;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement cartcount;
	
	@FindBy(xpath="//div[@class='inventory_details_name large_size']")
	public WebElement name;
	
	@FindBy(id="add-to-cart")
	public WebElement cart;
	
	@FindBy(xpath="//div[@class='inventory_details_price']")
	public WebElement price;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	public List<WebElement> addcart;
	
	public void username() {
		
	}
	
	
	
	

}
