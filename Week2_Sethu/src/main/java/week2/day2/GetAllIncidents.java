package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getAllIncidents() {
		//Endpoint
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		//Add request
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		//Send Request
		Response response = RestAssured.get();
		//Validate response
		response.prettyPrint();
		System.out.println("Status code:"+ response.statusCode());
	}

}
