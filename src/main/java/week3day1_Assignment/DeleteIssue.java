package week3day1_Assignment;

//Assignment2: Chaining the Requests in RestAssured
//3. Delete the issue created in the previous step by adding dependency (Add assertion for all Request). 


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIssue {
	
	@Test//(dependsOnMethods= {"week3day1_Assignment.CreateIssueWith2Data.CreateIssueWithMultipleData"})
	public void UpdateIssue() {
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		
		Response response = RestAssured.given()
					.contentType(ContentType.JSON)
					.log()
					.all()
					.delete("21272")
					.then()
					.assertThat()
					.contentType(ContentType.JSON)
					.statusCode(204)
					.extract()
					.response();
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
