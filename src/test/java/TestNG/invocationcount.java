package TestNG;

import org.testng.annotations.Test;

public class invocationcount {
	
	@Test(invocationCount=4)
	public void invocationcount() {
		System.out.println("Hi Hello");
	}

	@Test(invocationCount=1)
	public void invocationcount1() {
		System.out.println("Hi Hello");
	}
	
	@Test(invocationCount=0)
	public void invocationcount2() {
		System.out.println("Hi Hello");
	}
}
