package week2day2_Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJiraIssue extends BaseTest {
	
	@Test
	public void CreateJiraIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		Response Create_Response = RestAssured.given()
				//.log().all()
				.contentType(ContentType.JSON).body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RA\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"create issue in RA project\",\r\n" + 
				"        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}").post();
		
		//Create_Response.then().log().all();
		
		Create_Response.prettyPrint();
		System.out.println(Create_Response.statusCode());
		ID=Create_Response.jsonPath().get("id");
		System.out.println("ID-"+ID);
		
	}

}
