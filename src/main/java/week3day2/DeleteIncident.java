package week3day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends BaseTest {
	
	@Test(dependsOnMethods= {"week3day2.CreateIncidentWithoutBody.CreateIncident"})
	public void DeleteIncident() {
		
		RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
		
		RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
		
		Response response = RestAssured.given().pathParam("sys_id",sys_id)
							.delete("{sys_id}");
							
							
	    //response.prettyPrint();
		
		System.out.println(response.statusCode());
	}
}
