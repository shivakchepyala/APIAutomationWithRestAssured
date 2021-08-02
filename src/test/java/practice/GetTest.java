package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetTest {

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
