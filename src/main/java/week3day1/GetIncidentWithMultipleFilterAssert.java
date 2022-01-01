package week3day1;

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

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GetIncidentWithMultipleFilterAssert {
  @Test
  public void GetIncidentWithMultipleFilter() {
	  
	  RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/incident";
	  RestAssured.authentication=RestAssured.basic("admin", "x5g2eiBRNfQY");
	  
	  Map<String,String> allQueryParam=new HashMap<>();
	  allQueryParam.put("sysparm_fields", "sys_id,number,category");
	  allQueryParam.put("sysparam_limit","5");
	  
	   
	 RestAssured.given().queryParams(allQueryParam)
			  			.accept(ContentType.JSON).get()
			  			.then()
			  			.assertThat()
			  			.statusCode(200)
			  			.contentType(ContentType.JSON)
			  			//.body("result.number[1]",Matchers.equalTo("INC0009002"))
			  			.body("result.number",Matchers.hasItem("INC0009002"))
			  			.extract()
			  			.response()
			  			.prettyPrint();
	  
	 
	  
  }
  

}
