package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/JiraIssue.feature"
				,glue= {"steps","runner"},monochrome=true)

public class JIRARunCucumber extends AbstractTestNGCucumberTests {

}
