package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {
                "src/test/resources/Tamilarasu/AddNewStock.feature"
        },

        glue = {"stepDefinition", "hooks"},

        plugin = {
                "pretty",

                // Cucumber HTML Report
                "html:target/cucumber-report.html",

                // Cucumber JSON Report
                "json:target/cucumber-report.json",

                // Extent Report
             

                // Allure Report
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        monochrome = true
)

public class TestNGRunner
        extends AbstractTestNGCucumberTests {

}