package week5day1_Assignment_WireMock;
/*
 *ii) Get All change requests and print the change request number that belongs to of type Normal, Using WireMock recording. 

 */
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllChangeRequest {
	
	
	@Test
	public void GetAllChangeRequest() {
		
		RestAssured.baseURI="http://localhost:8081/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
		
		Response response = RestAssured.given()
					.contentType(ContentType.JSON)
					.queryParam("type","normal")
					.get();
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	}

}
