package RestAssuredProject.RestAssuredProject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Httprequest {

	int id;
	@Test(priority=1)
	void getUsers()
	{
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		// .get("https://reqres.in/api/users?page=2")
		.then()
		 .statusCode(200)
		 .body("size()", equalTo(100))
		   .log().all();
		
	}
	@Test(priority=2)
	void createUser()
	{
		HashMap map=new HashMap();
		map.put("name", "sriram");
		map.put("job", "TestLead");
				
		id = given()
		.contentType("application/json")
		.body(map)
		
		.when()
		.post("https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(201)
		 .log().all()
		 .extract()
		 .jsonPath().getInt("id");
		 
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		HashMap map=new HashMap();
		map.put("name", "john");
		map.put("job", "teacher");
				
		given()
		.contentType("application/json")
		.body(map)
		
		.when()
		.put("https://jsonplaceholder.typicode.com/posts/"+id)
		
		
		.then()
		.statusCode(200)
	    .log().all();
		 
	}
}
