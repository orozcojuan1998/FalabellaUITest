package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/filters/filter.feature",
        glue="steps"
)
public class Runner {}