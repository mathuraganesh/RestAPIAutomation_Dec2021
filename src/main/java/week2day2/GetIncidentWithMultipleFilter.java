package week2day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GetIncidentWithMultipleFilter {
  @Test
  public void GetIncidentWithMultipleFilter() {
	  
	  RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
	  RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
	  
	  Map<String,String> allQueryParam=new HashMap<>();
	  allQueryParam.put("sysparm_fields", "sys_id,short_description,category");
	  allQueryParam.put("category","software");
	  
	   
	  Response response = RestAssured.given()
			  						.queryParams(allQueryParam)
			  						.accept(ContentType.JSON).get();
	  System.out.println(response.statusCode());
	  //if result is an array
	  List<String> allsysid = response.jsonPath().getList("result.sys_id");
	  System.out.println(allsysid);
	  
	//if result is not an array
	 // String sysid = response.jsonPath().get("result.sys_id");
	  
	  
  }
  

}
