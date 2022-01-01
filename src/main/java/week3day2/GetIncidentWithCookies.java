package week3day2;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithCookies {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		//RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		
		Response response=RestAssured.given()
				.cookie("JSESSIONID", "E897868E772CCC3489CB8F1535DD0860")
				.get();
		//Response response = RestAssured.get();
		Map<String, String> Allcookies = response.getCookies();	
		for (Entry<String, String> eachEntry : Allcookies.entrySet()) {
			System.out.println(eachEntry.getKey()+":"+eachEntry.getValue());
		}
		
		System.out.println(response.statusCode());
				
				
	}

}
