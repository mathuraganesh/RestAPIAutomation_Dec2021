package week2day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestWithReqBody {
	
	@Test
	public void ChangeRequestWithReqBody() {
		
		File InputFile=new File("./data/ChangeRequest.json");
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response Create_Response = RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON).body(InputFile).post();
		Create_Response.then().log().all();
		String sys_id = Create_Response.jsonPath().get("result.sys_id");
		System.out.println(Create_Response.statusCode());
		System.out.println("Sys_id-"+sys_id);
		
	}

}
