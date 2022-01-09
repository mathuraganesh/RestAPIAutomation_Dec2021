package week6day2_GraphQL;

import org.testng.annotations.Test;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GitHub {
	
	
	String jsonBody="{" + 
			"  viewer {" + 
			"    login" + 
			"  }" + 
			"  repository(name: \"APIAutomationDoc_Dec-2021\", owner: \"mathuraganesh\") {" + 
			"    createdAt" + 
			"    id" + 
			"    owner {" + 
			"      id" + 
			"      avatarUrl" + 
			"    }" + 
			"  }" + 
			"}";
	
	@Test
	public void GitHub() {
		
		RestAssured.baseURI="https://api.github.com/graphql";
		
		Response response = RestAssured.given()
					.header(new Header("Authorization","Bearer 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"))
					.log().all().contentType(ContentType.JSON)
					.body(ConvertJsonToString(jsonBody))
					.post();
		response.prettyPrint();
		System.out.println(response.statusCode());
	}
	
	
	private static String ConvertJsonToString(String JsonBody) {
		
		JsonObject obj=new JsonObject();
		obj.add("query",JsonBody);
		
		return obj.toString();
		
	}

}
