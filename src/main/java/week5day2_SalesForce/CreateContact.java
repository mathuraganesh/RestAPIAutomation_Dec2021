package week5day2_SalesForce;

//a)Create a new contact


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateContact extends BaseApi {
	
	

	@Test
	public void CreateContact() {
		
		RestAssured.baseURI="https://cgi-4b3-dev-ed.my.salesforce.com/services/data/v20.0/sobjects/Contact";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mET6!AQ8AQInXF6Fk767oFbyptcd.SObV8dZ4rEA_gU54dXl5RKGqaET5LcEIeOR.pDseejhViiJvnPQvIC7eLxFH.7wDyN82RBQi");
		Response response = RestAssured.given()
										.contentType(ContentType.JSON)
										.log().all()
										.body("{\r\n" + 
												"    	\"FirstName\": \"Divya\",\r\n" + 
												"    	\"LastName\": \"Lakshmi\" \r\n" + 
												"	}")
										.post()
										.then().log().all().extract().response();
		response.prettyPrint();
		ID = response.jsonPath().get("id");
		System.out.println(ID);
		System.out.println(response.statusCode());
		
		
	
	}

}
