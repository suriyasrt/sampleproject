package RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import Basepackage.ApiBasetest;
import Specs.SpecBuilder;

import static org.hamcrest.Matchers.*;

public class getapivalidation extends ApiBasetest {
	
	@Test
	public void getrequest() {

	
	
		given()
        .spec(SpecBuilder.getRequestSpec())
        .log().all()
    .when()
        .get()
    .then()
        .log().all()
        .statusCode(200)
        .body("id", equalTo(1))
        .body("userId", notNullValue())
        .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
        .body("body", containsString("quia et suscipit"));
}
	
	
}
