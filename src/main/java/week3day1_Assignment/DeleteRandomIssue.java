package week3day1_Assignment;

//Delete the random issue in jira

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRandomIssue {
	
	@Test
	public void DeleteIssue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
	    Response response = RestAssured.given().delete("23125");
	    System.out.println(response.statusCode());
	}

}
