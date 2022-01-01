package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefIncidentManagement {
	
	private static Response response;
	
	@Given("^Set the EndPoint$")
	public void InitEndPoint() {
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
	}
	
	@And("^Enter  the basic Authentication with Valid Credentials$")
	public void EnterCredentials() {
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
	}
	
	@When("^Create the Post Request$")
	public void CreatePostRequest() {
		
		response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
	}
	
	@When("Create the Post Request with Body as {string} and {string}")
	public void CreatePostWithBody(String desc,String category) {
		response=RestAssured.given()
							.contentType(ContentType.JSON)
							.body("{\"description\":\""+desc+"\",\"category\": \""+category+"\"}")
							.post();
							
							
	}
	//@Then("^Verify the status code as {int}$")
	@Then("^Verify the status code as (.*)$")
	public void VerifyStatus(String code) {
		response.then()
				.statusCode(Integer.parseInt(code))
				.extract()
				.response();
	}
	
	@And("^Verify the Response body contain ContentType as (.*)$")
	public void VerifyContentType(String type) {
		if(type.toLowerCase().contains("json")) {
			response.then()
					.contentType(ContentType.JSON)
					.extract()
					.response();
		}
		else if(type.toLowerCase().contains("xml")) {
				response.then()
				.contentType(ContentType.XML)
				.extract()
				.response();
		}
		else {
			throw new RuntimeException("Content Type is not Matching");		
		}
		response.prettyPrint();
		
		
		
	}

}
