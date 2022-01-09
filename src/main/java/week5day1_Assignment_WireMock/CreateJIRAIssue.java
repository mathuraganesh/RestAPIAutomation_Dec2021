package week5day1_Assignment_WireMock;


/*i) Create a change request of type emergency with the body of XML type
 *  and Validate status code, contentType, and Body with a change request, Using WireMock stub for.
 */
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJIRAIssue {
	
	
	@BeforeMethod
	public void StubSample() {
		WireMock.stubFor(post("/rest/api/2/issue/")
				.willReturn(aResponse()
				.withStatus(201)
				.withHeader("accept","application/json")
				.withHeader("content-type","application/json")
				.withBody("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"    \"project\":\r\n" + 
						"                {\r\n" + 
						"                    \"key\": \"RA\"\r\n" + 
						"                },\r\n" + 
						"    \"summary\": \"create issue in RA project\",\r\n" + 
						"    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
						"    \"issuetype\": {\r\n" + 
						"                    \"name\": \"Bug\"\r\n" + 
						"                }\r\n" + 
						"    }\r\n" + 
						"}\r\n" + 
						"")
				));
				
	}
	
	
	@Test
	public void CreateJIRAIssue() {
		
		
		RestAssured.baseURI="http://localhost:8081/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Edlmc89n3ez7IdGHjCv5A863");
		
		Response response = RestAssured.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body("{\r\n" + 
							"    \"fields\": {\r\n" + 
							"    \"project\":\r\n" + 
							"                {\r\n" + 
							"                    \"key\": \"RA\"\r\n" + 
							"                },\r\n" + 
							"    \"summary\": \"create issue in RA project\",\r\n" + 
							"    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
							"    \"issuetype\": {\r\n" + 
							"                    \"name\": \"Bug\"\r\n" + 
							"                }\r\n" + 
							"    }\r\n" + 
							"}\r\n" + 
							"")
					.post()
					.then()
					.assertThat()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.body("key",Matchers.containsString("RA"))
					.extract().response();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}

}
