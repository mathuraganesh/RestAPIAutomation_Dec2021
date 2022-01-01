package week2day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentNoBody {
	
	
	@Test
	public void  CreateIncidentNoBody() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response Create_Response = RestAssured.given().contentType(ContentType.JSON).post();
		Create_Response.prettyPrint();
		String sys_id=Create_Response.jsonPath().get("result.sys_id");
		System.out.println(Create_Response.statusCode());
		System.out.println(sys_id);
	}

}
