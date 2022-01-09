package week5day2_SalesForce;


//d)List all the contact and verify the newly created is there.


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class GetAllContact {
	
	@Test(dependsOnMethods= {"week5day2_SalesForce.CreateContact.CreateContact",
			"week5day2_SalesForce.ContactAddress.Contact"
			,"week5day2_SalesForce.GetVerifyContactName.GetVerifyContactName"})
	public void GetAllContact() {
		
		RestAssured.baseURI="https://d5j000004mewteam-dev-ed.my.salesforce.com/services/data/v36.0/sobjects/contact";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mEWt!ARwAQA1XPgJ5Z6Z7uTNNCpP8qdUEPsol1aGdu8AZZf.VlaKVaNcKbivTnPpuqZ6MOuaOWG26zwF31EzXjtkqm8xuisdx_PiB");
		Response response = RestAssured.given()
										.accept(ContentType.JSON)
										.log().all()
										.get()
										.then()
										.assertThat()
										.body("recentItems.Name",Matchers.hasItem("Lakshmi, Divya"))
										.log().all().extract().response();
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	
	}

}
