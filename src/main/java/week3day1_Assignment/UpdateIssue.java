package week3day1_Assignment;

//Assignment2: Chaining the Requests in RestAssured
//2. Update the one of the issue with description and add body assertion, status code & contentType. 


import org.hamcrest.Matchers;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UpdateIssue {
	
	
	@Test
	public void UpdateIssue() {
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		Response response = RestAssured.given()
					.contentType(ContentType.JSON).log().all()
					.body("{\r\n" + 
							"    \"fields\": {\r\n" + 
							"       \r\n" + 
							"        \"description\": \"Issue updated via RestAssured on Oct 29 2021 --second time\"\r\n" + 
							"    }\r\n" + 
							"}")
					.put("21272")
					.then().log().all()
					.assertThat()
					//.body("fields.description",Matchers.containsString("Issue"))
					.contentType(ContentType.JSON)
					.statusCode(204)
					.extract()
					.response();
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
