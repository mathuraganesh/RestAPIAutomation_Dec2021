package salesfoceRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotation {
	
	@Before
	public void tearUp(Scenario sc) {
		
		RestAssured.baseURI="https://cgi-4b3-dev-ed.my.salesforce.com/services/data/v20.0/sobjects/contact";
		RestAssured.authentication=RestAssured.oauth2("00D5j000004mET6!AQ8AQInXF6Fk767oFbyptcd.SObV8dZ4rEA_gU54dXl5RKGqaET5LcEIeOR.pDseejhViiJvnPQvIC7eLxFH.7wDyN82RBQi");
		
	}
	
	@After
	public void tearDown(Scenario sc) {
	
	System.out.println(sc.getName()+":"+sc.getStatus());

	}
}
