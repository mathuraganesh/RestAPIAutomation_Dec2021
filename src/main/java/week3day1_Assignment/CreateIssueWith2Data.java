package week3day1_Assignment;

//Assignment2: Chaining the Requests in RestAssured
//1. Create issue with 2 sets of data and add body assertion, status code & contentType.

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;




import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssueWith2Data {
	
	
	@DataProvider(name="fetchdata")
		public String[][] getDataFile(){
			
			String[][] file=new String[2][1];
			file[0][0]="./data/CreateJiraIssue1.json";
			file[1][0]="./data/CreateJiraIssue2.json";
			return file;
			
	}
	
	@Test(dataProvider="fetchdata")
	public void CreateIssueWithMultipleData(String filepath) {
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		File file=new File(filepath);
		Response response = RestAssured.given().contentType(ContentType.JSON)
						   .body(file)
						   .post()
						   .then()
						   .assertThat()
						   .body("key",Matchers.containsString("RA"))
						   .statusCode(201)
						   .contentType(ContentType.JSON)
						   .extract()
						   .response();
		response.prettyPrint();
		System.out.println(response.statusCode());

	}
}
