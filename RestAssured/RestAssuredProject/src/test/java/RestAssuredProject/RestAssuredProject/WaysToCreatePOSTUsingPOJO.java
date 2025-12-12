package RestAssuredProject.RestAssuredProject;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class WaysToCreatePOSTUsingPOJO {
	
	@Test(priority=1)
	public void testPostUsingPOJO()
	{
		PostRequest_POJOclass data=new PostRequest_POJOclass();
		data.setFirstname("Sita");
		data.setMentorName("Gargi");
		data.setCourseName("Vedas");
		data.setDesignation("testDesignation");
        data.setLastName("Sri");	
        
        given()
        .contentType("application/json")
        .body(data)
        
        .when()
         .post("http://localhost:3000/friends")
        
        .then()
        .statusCode(201)
         .body("firstname",equalTo("Sita"))
         .body("mentorName",equalTo("Gargi"))
         .body("courseName", equalTo("Vedas"))
         .body("designation", equalTo("testDesignation"))
         .body("lastName", equalTo("Sri"))
         .log().all();
	}

	//@Test(priority=2)
	void delete()
	{
	
		given()
		
	.when()
	 .delete("http://localhost:3000/friends/5e01")
	.then()
	 .statusCode(200);
	
	}
}
