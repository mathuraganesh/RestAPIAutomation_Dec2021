package week2day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestDelete {
	
	@Test
	public void ChangeRequestDelete() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		Response response = RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON).delete("13aa2bc21ba4011005250f26624bcbc3");
		response.then().log().all();
		//String sys_id = response.jsonPath().get("result.sys_id");
		System.out.println(response.statusCode());
		//System.out.println("Sys_id-"+sys_id);
		
	}

}
