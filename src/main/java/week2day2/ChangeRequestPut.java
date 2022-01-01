package week2day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestPut {
	
	@Test
	public void ChangeRequestPut() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response response = RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON).body("{\r\n" + 
				"    \"description\": \"Test the Change Request Put Description\",\r\n" + 
				"    \"short_description\": \"Test the Change Request Put Short Description\"\r\n" + 
				"}").put("03792fce1b64011005250f26624bcbf8");
		response.then().log().all();
		String sys_id = response.jsonPath().get("result.sys_id");
		System.out.println(response.statusCode());
		System.out.println("Sys_id-"+sys_id);
		
	}

}
