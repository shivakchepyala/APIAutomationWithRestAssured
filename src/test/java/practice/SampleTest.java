package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SampleTest {
	
	@Test
	public void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
		System.out.println(response.getBody().asPrettyString());
		System.out.println("\n");
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void test_02() {
		
		baseURI = "https://reqres.in";
		given().when()
				.get("/api/users?page=2")
			.then()
				.statusCode(200)
				.body("data[1].id", equalTo(8));
		
	}

}
