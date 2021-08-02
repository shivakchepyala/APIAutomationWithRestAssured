package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


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
