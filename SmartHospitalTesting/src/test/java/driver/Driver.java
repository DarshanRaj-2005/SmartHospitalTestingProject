package driver;

import java.util.Map;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public Driver() {

        String browser = ConfigReader.getProperties().getProperty("browser");
        String headlessValue = ConfigReader.getProperties().getProperty("headless");

        boolean headless =
                headlessValue != null &&
                headlessValue.equalsIgnoreCase("true");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads";
            new File(downloadPath).mkdirs();

            options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "download.default_directory", downloadPath,
                "download.prompt_for_download", false,
                "download.directory_upgrade", true,
                "safebrowsing.enabled", true
            ));
            if (headless) {

                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
            }

            driver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (headless) {

                options.addArguments("--headless");
                options.addArguments("--width=1920");
                options.addArguments("--height=1080");
            }

            driver.set(new FirefoxDriver(options));
        }

        else {

            throw new RuntimeException("Invalid Browser Name: " + browser);
        }

        if (!headless) {

            getDriver().manage().window().maximize();
        }
    }

        public static void quitDriver() {
	        if (getDriver() != null) {
	            getDriver().quit();
	            driver.remove();
	        }
    }
}
