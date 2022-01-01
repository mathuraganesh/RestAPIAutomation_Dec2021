package week3day1;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncidentWithVerifySchema {
	
	
	@Test
	public void  CreateIncidentWithBody() {
		
		//Go to the Json schema generator in google copy the response and then generate schema put it in 
		//CreateIncidentSchema.json file and validate using JsonSchemaValidator.matchesJsonSchema(file)
		
		File file=new File("./data/CreateIncidentSchema.json");
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response Create_Response = RestAssured.given().contentType(ContentType.JSON)
										.body("{\r\n" + 
											"    \"description\": \"Test the Post Man Description\",\r\n" + 
											"    \"short_description\": \"Test the Postman Short Description\"\r\n" + 
											"}").post()
										.then()
										.body(JsonSchemaValidator.matchesJsonSchema(file))
										.extract()
										.response();
		Create_Response.prettyPrint();
		
		System.out.println(Create_Response.statusCode());
		
	}

}
