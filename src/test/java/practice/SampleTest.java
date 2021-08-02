package practice;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

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
	

}
