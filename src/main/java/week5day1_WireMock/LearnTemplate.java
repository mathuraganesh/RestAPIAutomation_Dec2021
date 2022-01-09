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

public class LearnTemplate {
		
	@Test
	public void CreateIncidentWithoutBody() {
		
		RestAssured.baseURI="http://localhost:8080/testleaf/training/course";
		//RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
		
		Response response = RestAssured.given()
					.queryParam("Course","Rest API")
					.queryParam("Type","Online")
					.contentType(ContentType.JSON)
					.get();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}

}
