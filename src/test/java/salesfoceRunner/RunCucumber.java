package salesfoceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/salesforceFeature"
				,glue= {"steps","salesforceRunner"},monochrome=true)
public class RunCucumber extends AbstractTestNGCucumberTests {

}
