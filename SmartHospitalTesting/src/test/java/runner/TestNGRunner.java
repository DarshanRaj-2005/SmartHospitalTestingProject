package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

         features = {"src/test/resources/feature_files/AddAmbulance.feature"},
//		,"src/test/resources/feature_files/login.feature"},
        
        
        glue = {"stepDefinition", "hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        monochrome = true
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
}
