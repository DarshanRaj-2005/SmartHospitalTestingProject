package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {
               
                "src\\test\\resources\\feature_files\\Janani_Sri\\Search_Patient.feature"
        },

        glue = {"stepDefinition", "hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            }
        )

public class TestNGRunner extends AbstractTestNGCucumberTests {

}