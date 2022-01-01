package week2.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentsWithMultipleFilter {
	
	@Test
	public void getAllIncidents() {
		//Endpoint
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		
		//Authentication
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		
		//Multiple queryparams can be added in a map
		Map<String, String> allQueryParams = new HashMap<String, String>();
		allQueryParams.put("sysparm_fields", "sys_id, category, number");
		allQueryParams.put("category", "software");
		
		//Add the request information and send the http request
		Response response = RestAssured.given().queryParams(allQueryParams).accept(ContentType.XML).get();
		
		System.out.println(response.statusCode());
		//If the result is an array
		List<String> allSysId = response.xmlPath().getList("response.result.sys_id");
		//If result is not an array
		//response.jsonPath().get("result.sys_id");
		System.out.println(allSysId);
	}

}
