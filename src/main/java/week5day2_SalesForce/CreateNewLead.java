package week5day2_SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//a) Create a new Lead
public class CreateNewLead extends BaseApi{
	
	
	@Test
	public void CreateNewLead() {
		
		RestAssured.baseURI="https://d5j000004mewteam-dev-ed.my.salesforce.com/services/data/v36.0/sobjects/Lead";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mEWt!ARwAQA1XPgJ5Z6Z7uTNNCpP8qdUEPsol1aGdu8AZZf.VlaKVaNcKbivTnPpuqZ6MOuaOWG26zwF31EzXjtkqm8xuisdx_PiB");
		Response response = RestAssured.given()
										.contentType(ContentType.JSON)
										.log().all()
										.body("{\r\n" + 
												"    	\"FirstName\": \"Divya\",\r\n" + 
												"    	\"LastName\": \"Vidya\",\r\n" + 
												"    	\"Company\": \"CGI\"  \r\n" + 
												"	}")
										.post()
										.then().log().all().extract().response();
		response.prettyPrint();
		ID=response.jsonPath().get("id");
		System.out.println(ID);
		System.out.println(response.statusCode());
		
		
	
	}

}
