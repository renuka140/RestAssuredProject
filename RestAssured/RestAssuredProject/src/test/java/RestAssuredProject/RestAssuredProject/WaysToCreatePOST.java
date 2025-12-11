package RestAssuredProject.RestAssuredProject;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@Test(priority=1)
public class WaysToCreatePOST
{
	public void postTestUsingHashMap()
	{
		
	HashMap map=new HashMap();

	map.put("firstname","Hanuman");
	map.put("mentorName","Ram");
	map.put("courseName","JAVA");
	map.put("designation","JAVA_Developer");
	map.put("lastname","Sri");
	
	given()
	.contentType("application/json")
	.body(map)
	
	.when()
	 .post("http://localhost:3000/friends")
	 
	.then()
	  .statusCode(201)
	  .body("firstname",equalTo("Hanuman"))
	  .body("mentorName",equalTo("Ram"))
	  .body("courseName",equalTo("JAVA"))
	  .body("designation",equalTo("JAVA_Developer"))
	  .body("lastname",equalTo("Sri"))
	  .log().all();
		
   }
	@Test(priority=2)
	void delete()
	{
	
		given()
		
	.when()
	 .delete("http://localhost:3000/friends/92d0")
	.then()
	 .statusCode(200);
	
	}
}
