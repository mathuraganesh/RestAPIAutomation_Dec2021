package week2day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllChangeRequestwithXML {
  @Test
  public void GetAllChangeRequest() {
	  
	  RestAssured.baseURI="https://dev117099.service-now.com/api/now/table/change_request";
	  RestAssured.authentication=RestAssured.basic("admin","x5g2eiBRNfQY");
	  Map<String,String> allQueryParam=new HashMap<>();
	  allQueryParam.put("sysparm_fields", "sys_id,short_description,category");
	  allQueryParam.put("category","software");
	  
	  Response response = RestAssured.given().queryParams(allQueryParam).accept(ContentType.XML).get();
	  System.out.println(response.statusCode());
	  
	  response.prettyPrint();
	  
	  List<String> allsysid = response.xmlPath().getList("response.result.sys_id");
	  
	  System.out.println(allsysid);
	  
  }
}
