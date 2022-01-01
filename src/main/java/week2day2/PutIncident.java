package week2day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutIncident {
	
	
	@Test
	public void  PutIncident() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		File InputFile=new File("./data/CreateIncident.json");
		Response Create_Response = RestAssured.given().contentType(ContentType.JSON)
									.log().all()  //Get the complete Request Info if we mention in given().log().all()
									.body("{\r\n" + 
											"    \"description\": \"Test the Incident with Put Description\",\r\n" + 
											"    \"short_description\": \"Test the Incident with Put Short Description\"\r\n" + 
											"}").put("3b32ef0e1b64011005250f26624bcb7b");
		//Create_Response.prettyPrint();
		String sys_id=Create_Response.jsonPath().get("result.sys_id");
		Create_Response.then().log().all();//Get the complete Response Info if we mention in then().log().all()
		System.out.println(Create_Response.statusCode());
		System.out.println("SYS_ID-"+sys_id);
	}

}
