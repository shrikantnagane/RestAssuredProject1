package apitests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test2GetAndPost {

	@Test (priority=-1)
	public void testGet() {
		
	baseURI= "https://reqres.in";
	
	given().
		get("/api/users?page=2").
	then().
		statusCode(200).
		body("data[3].first_name", equalTo("Byron")).
		body("data.first_name", hasItems("George","Byron"));
System.out.println(baseURI);
	}
	
	@Test (priority=1)
	public void testpost() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", "Shrikant");
		map.put("Job", "Sr. Quality Engineer");
		
		System.out.println(map);
		
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
		post("/api/users").
	then().
		statusCode(201).
		log().all();
		
	}
	
	
}
