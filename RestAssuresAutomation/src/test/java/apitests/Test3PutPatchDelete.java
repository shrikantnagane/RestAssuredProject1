package apitests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test3PutPatchDelete {

	@Test (priority=1)
	public void testput() {
				
		JSONObject request = new JSONObject();
		request.put("Name", "Shrikant");
		request.put("Job", "Sr. Quality Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
			
	given().
		header("Content-Type", "application/json").
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		put("/api/users/2").
	then().
		statusCode(200).
		log().all();
		
	}
	
	@Test (priority=2)
	public void testpatch() {
				
		JSONObject request = new JSONObject();
		request.put("Name", "Shrikant");
		request.put("Job", "Sr. Quality Engg.");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
			
	given().
		header("Content-Type", "application/json").
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		patch("/api/users/2").
	then().
		statusCode(200).
		log().all();
		
	}
	
	@Test (priority=3)
	public void testDelete() {
				
		
		
		baseURI = "https://reqres.in";
			
	given().
		
	when().
		delete("/api/users/2").
	then().
		statusCode(204).
		log().all();
		
	}
}
