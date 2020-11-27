package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature/WeatherForecast.feature",
		glue = "stepDefinations",
		plugin = {"pretty",
				"html:target/SystemTestReport/Html",
				"json:target/SystemTestReport/json/jsonRep.json",
				"junit:target/SystemTestReport/junit/report.xml"})
public class TestRunner {
	
}
