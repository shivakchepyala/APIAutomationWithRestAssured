package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class PostTest {
	
	@Test
	@SuppressWarnings("unchecked")
	public void testingPost() {
		
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}

}
