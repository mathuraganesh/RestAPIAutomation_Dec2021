package week3day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends BaseTest {
	
	@Test
	public void CreateIncident(){
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
	
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		
		Response response = RestAssured.given()
					.contentType(ContentType.JSON)
					.post();
		//response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		sys_id = response.jsonPath().get("result.sys_id");
		
		System.out.println(sys_id);
	}

}
