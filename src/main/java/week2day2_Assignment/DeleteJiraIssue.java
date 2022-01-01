package week2day2_Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteJiraIssue extends BaseTest {
	
	@Test
	public void DeleteJiraIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Px2EQOkSoSPm1EzA2h9CDDA1");
		Response Create_Response = RestAssured.given().log().all()
		.contentType(ContentType.JSON).delete("22984");
		
		Create_Response.then().log().all();
		System.out.println(Create_Response.statusCode());
		//String sys_id=Create_Response.jsonPath().getString("result")
		
	}

}
