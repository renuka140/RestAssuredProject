package RestAssuredProject.RestAssuredProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WaysToCreatePOSTUsingExistingJSONFile {
	
	//@Test(priority=1)
	 void testpostusingexistingJsonfile() throws FileNotFoundException
	{
		File f=new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/friends")
		
		.then()
		.statusCode(201)
		.body("firstname",equalTo("AG"))
		.body("mentorName",equalTo("Shiva"))
		.body("courseName",equalTo("SAP_Testing"))
		.body("designation",equalTo("Project Lead1"))
		.body("lastname", equalTo("sri"))
		.log().all();
	}

	@Test(priority=2)
		void delete()
		{
		
			given()
			
		.when()
		 .delete("http://localhost:3000/friends/369")
		.then()
		 .statusCode(200);
		
		}
}
