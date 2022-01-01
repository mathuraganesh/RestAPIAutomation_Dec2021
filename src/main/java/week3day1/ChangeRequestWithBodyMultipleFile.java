package week3day1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestWithBodyMultipleFile {
	
	@DataProvider(name="fetchdata")
	public String[][] getData() {
		//No of rows=No of Data
		//No of column=No of value
		//String[] data=new String[2];  -> we can use this syntax after TestNG 6
		String[][] data=new String[2][1];
		//1st Row
		data[0][0]="./data/ChangeRequest.json";
		//data[0]="./data/ChangeRequest.json";  -> we can use this syntax after TestNG 6
		//2nd Row
		data[1][0]="./data/ChangeRequest1.json";
		//data[1]="./data/ChangeRequest1.json";  -> we can use this syntax after TestNG 6
		return data;
	}
	@Test(dataProvider="fetchdata")
	public void changeRequestWithBody(String filepath) {
		//Step 1: Get Url/EndPoint
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
		//Step 2: Authentication Basic
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		//Step 3:Request Type get
		File file=new File(filepath);
		
		
		Response response=RestAssured
							.given()
							.contentType(ContentType.JSON)
							.body(file)
							.post();
		//Step 4:Print Response Body
		response.prettyPrint();
		//Step 5: Print Status Code
		System.out.println("Status Code-"+response.statusCode());
		
							
		
	}

}
