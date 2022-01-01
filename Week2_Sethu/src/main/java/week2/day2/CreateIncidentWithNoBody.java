package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithNoBody {
	
	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		
		Response create_response = RestAssured.given().contentType(ContentType.JSON).post();
		System.out.println(create_response.statusCode());
		//create_response.prettyPrint();
		String sys_id = create_response.jsonPath().get("result.sys_id");
		System.out.println("SYS_ID: "+sys_id);
		
	}

}
