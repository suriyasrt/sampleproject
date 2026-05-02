package UIverification;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class brokenlinksTest {
	WebDriver driver;
	@BeforeTest
	public void applaunch() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void brokenlinks() throws Exception, IOException {
		
		List <WebElement>links=driver.findElements(By.tagName("a"));
		
		
		System.out.println("The Links Size is "+links.size());

		for(int i=0;i<links.size();i++){

		String url=links.get(i).getAttribute("href");

		if(url==null || url.isEmpty()){

		System.out.println("It is Empty");

		continue;

		}

		HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
		connection.setConnectTimeout(5000);
		connection.connect();


		int statuscode=connection.getResponseCode();

		if(statuscode>400)
		{
		System.out.println("It is broken");
		}
		else{
			System.out.println("It is valid link");
		}

		
			}
		
		
		
	}
	
}

/*List<WebElement>Links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links on the page"+Links.size());
		
		for (int i=0;i<Links.size();i++) {
			
			String url=Links.get(i).getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println("It is Empty");
				continue;
			}
			
			HttpURLConnection connection=(HttpURLConnection)new URL(url).openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();
			
			int statuscode=connection.getResponseCode();
			
			if(statuscode>400) {
				System.out.println("It is Broken Link");
			}
			else {
				System.out.println("It is Valid link");
			}
		}
		
		
 * 
 * 
 */


