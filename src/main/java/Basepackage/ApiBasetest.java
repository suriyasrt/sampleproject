package Basepackage;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

import utils.configreader;

public class ApiBasetest {
	
	@BeforeTest
	public void setup() {
		
		RestAssured.baseURI = configreader.getProperty("baseURI");
    	RestAssured.basePath = configreader.getProperty("basePath"); 	
		
		
		
	}

}
