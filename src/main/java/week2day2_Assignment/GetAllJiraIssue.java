package week2day2_Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllJiraIssue {
	
	@Test
	public void GetAllJiraIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RA";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		
		Response response = RestAssured.given().log().all().accept(ContentType.JSON).get();
		response.then().log().all();
		System.out.println(response.statusCode());
	}

}
