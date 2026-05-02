package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class crossWordPOJ {
	
	WebDriver driver;

	public crossWordPOJ(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search")
	public WebElement search;
	

	@FindBy(xpath="(//button[@type='button'])[1]")
	public WebElement viewmore;
	
	@FindBy(xpath="//div[normalize-space()='Relevance']")
	public WebElement sortby;
	
	@FindBy(id="wizzy-sort-select")
	public WebElement selectoption;

}
