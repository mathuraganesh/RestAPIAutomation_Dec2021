package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefJiraIssues {
	
	private static Response response;
	
	@Given("Send the request with body as {string} and {string}")
	public void CreateRequest(String sum,String desc) {
		
		response = RestAssured.given()
					.contentType(ContentType.JSON)
					.body("{\r\n" + 
							"    \"fields\": {\r\n" + 
							"        \"project\": {\r\n" + 
							"            \"key\": \"RA\"\r\n" + 
							"        },\r\n" + 
							"        \"summary\": \""+sum+"\",\r\n" + 
							"        \"description\": \""+desc+"\",\r\n" + 
							"        \"issuetype\": {\r\n" + 
							"            \"name\": \"Bug\"\r\n" + 
							"        }\r\n" + 
							"    }\r\n" + 
							"}")
					.post();
		
	}
	
	
	@Given("Update the request with body as {string} and {string}")
	public void UpdateRequest(String sum,String desc) {
		
		response = RestAssured.given()
					.contentType(ContentType.JSON)
					.body("{\r\n" + 
							"    \"fields\": {\r\n" + 
							"        \"project\": {\r\n" + 
							"            \"key\": \"RA\"\r\n" + 
							"        },\r\n" + 
							"        \"summary\": \""+sum+"\",\r\n" + 
							"        \"description\": \""+desc+"\",\r\n" + 
							"        \"issuetype\": {\r\n" + 
							"            \"name\": \"Bug\"\r\n" + 
							"        }\r\n" + 
							"    }\r\n" + 
							"}")
					.put("23128");
		
	}
	
	
	@And("^Verify the Status code as (.*)$")
	public void VerifyStatusCode(String code) {
		response.then()
				.assertThat()
				.statusCode(Integer.parseInt(code))
				.extract()
				.response();
		
	}
	
	@Then("^Verify the response body contains ContentType as (.*)$")
	public void VerifyResponseBody(String type) {
		if(type.toLowerCase().contains("json")) {
			
			response.then()
					.assertThat()
					.contentType(ContentType.JSON)
					.extract()
					.response();
		}
		else if(type.toLowerCase().contains("xml")) {
			
			response.then()
					.assertThat()
					.contentType(ContentType.XML)
					.extract()
					.response();
	}
		else {
			System.out.println("Invalid Match");
		}
		response.prettyPrint();
		
	}

}
