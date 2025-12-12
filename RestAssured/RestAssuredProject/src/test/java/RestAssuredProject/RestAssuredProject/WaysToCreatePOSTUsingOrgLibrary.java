package RestAssuredProject.RestAssuredProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class WaysToCreatePOSTUsingOrgLibrary {
	
	
	@Test(priority=1)
	public void postTestUsingOrgLibrary()
	{
		
	JSONObject data=new JSONObject(); 

	data.put("firstname","testfname");
	data.put("mentorName","testmentorname");
	data.put("courseName","testcoursename");
	data.put("designation","testdesignation");
	data.put("lastname","testLastname");
	
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	 .post("http://localhost:3000/friends")
	 
	.then()
	  .statusCode(201)
	  .body("firstname",equalTo("testfname"))
	  .body("mentorName",equalTo("testmentorname"))
	  .body("courseName",equalTo("testcoursename"))
	  .body("designation",equalTo("testdesignation"))
	  .body("lastname",equalTo("testLastname"))
	  .log().all();
		
   }
	
	@Test(priority=2)
	void delete()
	{
	
		given()
		
	.when()
	 .delete("http://localhost:3000/friends/a723")
	.then()
	 .statusCode(200);
	
	}


}
