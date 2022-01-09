package week5day2_SalesForce;

//c)Update the new same contact with different address and verify the contact name.

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ContactAddress extends BaseApi {

		
	@Test(dependsOnMethods="week5day2_SalesForce.CreateContact.CreateContact")
	public void Contact() {
		
		RestAssured.baseURI="https://d5j000004mewteam-dev-ed.my.salesforce.com/services/data/v36.0/sobjects/contact";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mEWt!ARwAQA1XPgJ5Z6Z7uTNNCpP8qdUEPsol1aGdu8AZZf.VlaKVaNcKbivTnPpuqZ6MOuaOWG26zwF31EzXjtkqm8xuisdx_PiB");
		Response response = RestAssured.given()
										.contentType(ContentType.JSON)
										.log().all()
										.body("{\"OtherStreet\": \"C10 Road\",\r\n" + 
												"\"OtherCity\": \"Chennai\",\r\n" + 
												"\"OtherState\": \"Tamil Nadu\",\r\n" + 
												"\"OtherPostalCode\": \"600119\",\r\n" + 
												"\"OtherCountry\": \"India\"\r\n" + 
												"}\r\n" + 
												"")
										.patch(ID)
										.then()
										.log().all().extract().response();
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	
	}

	}