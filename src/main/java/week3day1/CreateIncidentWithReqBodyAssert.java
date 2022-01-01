package week3day1;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithReqBodyAssert {
	
	
	@Test
	public void  CreateIncidentWithBody() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response Create_Response = RestAssured.given().contentType(ContentType.JSON)
										.body("{\r\n" + 
											"    \"description\": \"Test the Post Man Description\",\r\n" + 
											"    \"short_description\": \"Test the Postman Short Description\"\r\n" + 
											"}").post()
										.then()
										.assertThat()
										       //path                    Value
										//.body("result.short_description",Matchers.equalTo("Test the Postman Short Description"))
										.body("result.short_description",Matchers.containsString("Postman"))
										.extract()
										.response();
		//Create_Response.prettyPrint();
		String sys_id=Create_Response.jsonPath().get("result.sys_id");
		System.out.println(Create_Response.statusCode());
		System.out.println("SYS_ID-"+sys_id);
	}

}
