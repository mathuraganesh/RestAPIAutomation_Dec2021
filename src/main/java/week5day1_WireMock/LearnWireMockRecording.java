package week5day1_WireMock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import  com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import  static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnWireMockRecording {
	
	@Test
	public void CreateIncidentWithoutBody() {
		
		RestAssured.baseURI="http://localhost:8080/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
		
		Response response = RestAssured.given()
					.contentType(ContentType.JSON)
					.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}

}
