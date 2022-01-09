package week5day1_Assignment_WireMock;
/*
 *ii) Get All Issues from the project and print the Id(or)Key, Using WireMock recording. 

 */
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllJIRAIssue {
	
	
	@Test
	public void GetAllJIRAIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RA";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Edlmc89n3ez7IdGHjCv5A863");
		
		Response response = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.get();
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	}

}
