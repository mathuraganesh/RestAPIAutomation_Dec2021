package week5day2_SalesForce;

//b)verify the contact name

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetVerifyContactName extends BaseApi {

		
	@Test(dependsOnMethods= {"week5day2_SalesForce.CreateContact.CreateContact"
			,"week5day2_SalesForce.ContactAddress.Contact"})
	public void GetVerifyContactName() {
		
		RestAssured.baseURI="https://d5j000004mewteam-dev-ed.my.salesforce.com/services/data/v36.0/sobjects/contact";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mEWt!ARwAQA1XPgJ5Z6Z7uTNNCpP8qdUEPsol1aGdu8AZZf.VlaKVaNcKbivTnPpuqZ6MOuaOWG26zwF31EzXjtkqm8xuisdx_PiB");
		Response response = RestAssured.given()
										.accept(ContentType.JSON)
										.log().all()
										.get(ID)
										.then()
										.assertThat()
										.body("Name",Matchers.equalTo("Divya Lakshmi"))
										.log().all().extract().response();
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	
	}

	}