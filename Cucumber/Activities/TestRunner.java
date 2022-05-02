package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Activity3.feature",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"json: json-report.json"}
)
public class TestRunner {
}
