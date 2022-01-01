package week3day1_Assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

/*Assignment1: 

1. Create Issue in jira by passing body as String and validate response schema.
2.  Delete the random issue in jira*/


public class CreateJiraWithBody {
	
	@Test
	public void CreateJiraWithBodyAsString() {
		
		File file=new File("./data/JiraSchema.json");
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
	    Response response = RestAssured.given().contentType(ContentType.JSON)
	    		.body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RA\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"create issue in RA project\",\r\n" + 
				"        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}").post()
	    			.then()
	    			.body(JsonSchemaValidator.matchesJsonSchema(file))
	    			.extract()
	    			.response();
	    
	    response.prettyPrint();
	    System.out.println(response.statusCode());
					
					
	}
	

}
