package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class JiraCucumberAnnotation {
	
	@Before
	public void inIT(Scenario sc) {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","Qft7YQDlZVus8ezTj10XC08B");
		
	}
	
	@After
	public void tearDown(Scenario sc) {
		System.out.println(sc.getName()+":"+sc.getStatus());
	}
			

}
