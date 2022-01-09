package week5day1_Assignment_WireMock;


/*i) Create a change request of type emergency with the body of XML type
 *  and Validate status code, contentType, and Body with a change request, Using WireMock stub for.
 */
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateChangeRequest {
	
	
	@BeforeMethod
	public void StubSample() {
		WireMock.stubFor(post("/api/now/table/change_request")
				.willReturn(aResponse()
				.withStatus(201)
				.withHeader("accept","application/xml")
				.withHeader("content-type","application/xml")
				.withBody("<request><entry><type>emergency</type></entry></request>")
				));
				
	}
	
	
	@Test
	public void CreateChangeRequest() {
		
		//RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
		RestAssured.baseURI="http://localhost:8081/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
		
		Response response = RestAssured.given()
					.accept(ContentType.XML)
					.contentType(ContentType.XML)
					.body("<request><entry><type>emergency</type></entry></request>")
					.post()
					.then()
					.assertThat()
					.statusCode(201)
					.contentType(ContentType.XML).extract().response();
					//.body(arg0, arg1);
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}

}
