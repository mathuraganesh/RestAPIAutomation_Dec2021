package week2day2_Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateJiraIssue extends BaseTest {
	
	@Test
	public void UpdateJiraIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		Response Create_Response = RestAssured.given().log().all()
		.contentType(ContentType.JSON).body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"description\": \"Issue updated via RestAssured Put on Oct 21 2021 --second time\"\r\n" + 
				"    }\r\n" + 
				"}").put("21272");
		
		Create_Response.then().log().all();
		System.out.println(Create_Response.statusCode());
		
		//String sys_id=Create_Response.jsonPath().getString("result")
		
	}

}
