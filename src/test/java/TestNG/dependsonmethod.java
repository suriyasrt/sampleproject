package TestNG;

import org.testng.annotations.Test;

public class dependsonmethod {
	
	@Test(enabled=true)
	public void login () {
		
		System.out.println("New login");
		
	}

	@Test(dependsOnMethods="login")
	public void dashboard() {
		System.out.println("Depends on Login method");
		
	}
}
