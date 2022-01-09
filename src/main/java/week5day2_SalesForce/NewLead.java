package week5day2_SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NewLead extends BaseApi{
	
	
	@Test(dependsOnMethods="week5day2_SalesForce.CreateNewLead.CreateNewLead")
	public void NewLead() {
		
		RestAssured.baseURI="https://d5j000004mewteam-dev-ed.my.salesforce.com/services/data/v36.0/sobjects/Lead";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mEWt!ARwAQA1XPgJ5Z6Z7uTNNCpP8qdUEPsol1aGdu8AZZf.VlaKVaNcKbivTnPpuqZ6MOuaOWG26zwF31EzXjtkqm8xuisdx_PiB");
		Response response = RestAssured.given()
										.contentType(ContentType.JSON)
										.log().all()
										.body("{\r\n" + 
												"    	\"FirstName\": \"Divya\",\r\n" + 
												"    	\"LastName\": \"Vidya\",\r\n" + 
												"    	\"Company\": \"IBM\"  \r\n" + 
												"	}")
										.patch(ID)
										.then().log().all().extract().response();
		response.prettyPrint();
		System.out.println(response.statusCode());
		
		
	
	}

}
