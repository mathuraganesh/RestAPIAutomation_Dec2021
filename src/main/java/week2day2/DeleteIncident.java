package week2day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {
	
	
	@Test
	public void  DeleteIncident() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		//File InputFile=new File("./data/CreateIncident.json");
		Response delete = RestAssured.given().contentType(ContentType.JSON)
									.log().all()  //Get the complete Request Info if we mention in given().log().all()
									.delete("b3862fce1b64011005250f26624bcbf0");
		//Create_Response.prettyPrint();
		//String sys_id=Create_Response.jsonPath().get("result.sys_id");
		//Create_Response.then().log().all();//Get the complete Response Info if we mention in then().log().all()
		System.out.println(delete.statusCode());
		//System.out.println("SYS_ID-"+sys_id);
	}

}
