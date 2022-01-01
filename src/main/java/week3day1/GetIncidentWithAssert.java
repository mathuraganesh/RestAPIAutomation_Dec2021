package week3day1;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithAssert {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		
		
		Response response = RestAssured.get()
					.then()
					.assertThat()  //Optional syntax to understand the assert
					.statusCode(201)
					.contentType(ContentType.JSON)
					.extract()  //Change from Validate response to response 
					.response();
		response.prettyPrint();
		
		System.out.println(response.statusCode());
				
				
	}

}
