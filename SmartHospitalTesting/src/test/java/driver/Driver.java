package driver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

import org.openqa.selenium.WebDriver;


public class Driver {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {

		return driver.get();
	}

	public Driver() {

		    String browser = ConfigReader.getProperties().getProperty("browser");
		    String headlessValue = ConfigReader.getProperties().getProperty("headless");

		    boolean headless = headlessValue != null && headlessValue.equalsIgnoreCase("true");

		    if (browser.equalsIgnoreCase("chrome")) {

		        WebDriverManager.chromedriver().setup();
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");

		        options.setExperimentalOption("prefs", Map.of(
		            "credentials_enable_service", false,
		            "profile.password_manager_enabled", false
		        ));

		        if (headless) {
		            options.addArguments("--headless=new");
		        }

		        driver.set(new ChromeDriver(options));

		    } else if (browser.equalsIgnoreCase("firefox")) {

		        WebDriverManager.firefoxdriver().setup();
		        FirefoxOptions options = new FirefoxOptions();

		        if (headless) {
		            options.addArguments("--headless=new");
		        }

		        driver.set(new FirefoxDriver(options));

		    } else {
		       
		        throw new RuntimeException("Invalid Browser Name: " + browser);
		    }

		    getDriver().manage().window().maximize();
		}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}

}
