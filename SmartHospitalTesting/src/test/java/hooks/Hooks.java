package hooks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static final Logger log = LogManager.getLogger(Hooks.class);

	@Before
	public void setup() {

		new Driver();

		log.info("Browser launched");
	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = Driver.getDriver();

		if (scenario.isFailed()) {

			log.error("Scenario Failed : " + scenario.getName());

			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
				long time = System.currentTimeMillis();
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File dest = new File("target/screenshots/" + scenario.getName() + "_" + time + ".png");
				FileUtils.copyFile(src, dest);
				log.info("Screenshot Saved");
			} catch (Exception e) {
				log.error("Screenshot Failed " + e);
			}
		}

		else {
			log.info("Scenario Passed : " + scenario.getName());
		}

		Driver.quitDriver();

		log.info("Browser closed");
	}
}