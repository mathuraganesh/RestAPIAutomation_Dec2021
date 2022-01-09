package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepdefSalesForce {
	
	private static Response response;
	
	@Given("Create the Post with Body as {string} and {string}")
	public void CreatePostRequest(String firstName,String lastName) {
		
		response=RestAssured.given()
					.contentType(ContentType.JSON)
					.body("{\"FirstName\":\""+firstName+"\",\"LastName\": \""+lastName+"\"}")
					.log().all()
					.post();
					
				System.out.println(response.prettyPrint());
					
	}
	
	@And("^Verify the Response code as (.*)$")
	public void VerifyResponseCode(String code) {
		
		response.then()
				.assertThat()
				.statusCode(Integer.parseInt(code))
				.extract()
				.response();
	}
	
	@Then("Validate the Response Body Contains as {string}")
	public void ValidateResponseBody(String type) {
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
		else
			System.out.println("Invalid Matching");
		}
	

}
