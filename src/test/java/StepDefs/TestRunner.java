package StepDefs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "StepDefs",
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json", "junit:target/cucumber-reports/cucumber.xml"}
)
public class TestRunner {
}
