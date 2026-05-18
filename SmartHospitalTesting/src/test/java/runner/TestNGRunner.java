package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = {
        "src/test/resources/feature_files"
    },

    glue = {"stepDefinition", "hooks"},

    plugin = {
        "pretty",

        // Cucumber HTML Report
        "html:target/cucumber-report.html",

        // Cucumber JSON Report
        "json:target/cucumber-report.json",

        // Extent Report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

        // Allure Report
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },

    monochrome = true
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}