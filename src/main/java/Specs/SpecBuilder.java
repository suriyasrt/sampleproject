package Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.configreader;

public class SpecBuilder {
	
	
	 public static RequestSpecification getRequestSpec() {

	        return new RequestSpecBuilder()
	        		.setBaseUri(configreader.getProperty("baseURI"))   // ✅ Add this
	                .setBasePath(configreader.getProperty("basePath"))
	                .setContentType(configreader.getProperty("contentType"))
	                .build();
	    }

}
