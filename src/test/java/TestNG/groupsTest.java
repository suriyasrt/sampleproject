package TestNG;

import org.testng.annotations.Test;

public class groupsTest {
	@Test(groups= {"smoke"})
	public void testcase1() {
		System.out.println("Group test smoke 1");
	}
	
	@Test(groups= {"smoke","regression"})
	public void testcase2() {
		System.out.println("Group test smoke 2");
	}
	
	@Test(groups= {"smoke"})
	public void testcase3() {
		System.out.println("Group test smoke 3");
	}
	
	@Test(groups= {"regression"})
	public void testcase4() {
		System.out.println("Group test regression 1");
	}
	
	@Test(groups= {"regression","smoke"})
	public void testcase5() {
		System.out.println("Group test regression 2");
	}

}
