package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentsWithFilter {
	
	@Test
	public void getAllIncidents() {
		//Endpoint
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		//Add request
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		RequestSpecification inputRequest = RestAssured
											.given()
											.queryParam("sysparm_fields", "sys_id, category, number");
		//Send Request
		Response response = inputRequest.get();
		//Validate response
		response.prettyPrint();
		System.out.println("Status code:"+ response.statusCode());
	}

}
