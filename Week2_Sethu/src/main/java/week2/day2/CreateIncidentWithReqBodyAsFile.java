package week2.day2;

import java.io.File;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithReqBodyAsFile {
	
	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		
		File inputFile = new File("./data/CreateIncident.json");
		
		Response create_response = RestAssured.given().
										contentType(ContentType.JSON)
										.log()
										.all()
										.body(inputFile)
										.post();
		
		System.out.println(create_response.statusCode());
		create_response.then().log().all();
		String sys_id = create_response.jsonPath().get("result.sys_id");
		System.out.println("SYS_ID: "+sys_id);
		
	}

}
