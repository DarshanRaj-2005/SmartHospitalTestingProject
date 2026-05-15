package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {
               
                "src\\test\\resources\\feature_files\\Janani_Sri\\Add_Patient.feature"
        },

        glue = {"stepDefinition", "hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
               
        }
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

}