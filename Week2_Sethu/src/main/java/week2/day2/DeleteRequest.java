package week2.day2;


import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {
	
	@Test
	public void deleteIncident() {
		RestAssured.baseURI = "https://dev106238.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "KfTRMl3Slfw5");
		
		Response response = RestAssured.given().
		contentType(ContentType.JSON)
		.log()
		.all()
		.delete("30c656be2f944110dc8be93df699b62f");
		
		response.then().log().all();
		
	}

}
