package week2day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentWithFilter {

	@Test
	public void GetIncidentWithFilter() {
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
		RequestSpecification inputRequest = RestAssured.given().queryParam("sysparm_fields","sys_id,short_description");
		Response response = inputRequest.get();
		response.prettyPrint();
		System.out.println("Status Code-"+response.statusCode());
	}
	
}
