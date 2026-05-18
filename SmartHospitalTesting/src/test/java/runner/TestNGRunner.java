package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = {
        "src/test/resources/feature_files/Janani_Sri/Search_Patient.feature"
    },

    glue = {"stepDefinition"},

    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },

    monochrome = true
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

}
