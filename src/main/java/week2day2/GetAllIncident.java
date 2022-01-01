package week2day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	public static void main(String[] args) {
		//End Point
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		//Add Request
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		//Send Request
		Response response = RestAssured.get();
		//Validate Response
		
		response.prettyPrint();
		System.out.println("Status Code-"+response.statusCode());
		//Map<String,String> allQueryParams = new HashMap<String, String>();
		//allQueryParams

	}

}
