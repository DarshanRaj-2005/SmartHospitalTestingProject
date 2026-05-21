package driver;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    // ThreadLocal for Parallel Execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Getter Method
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Constructor
    public Driver() {

        String browser = ConfigReader.getProperties().getProperty("browser");
        String headlessValue = ConfigReader.getProperties().getProperty("headless");

        boolean headless = headlessValue != null
                && headlessValue.equalsIgnoreCase("true");

        // =========================
        // CHROME
        // =========================

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Disable Notifications
            options.addArguments("--disable-notifications");

            // Disable Password Manager Popup
            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false));

            // HEADLESS SETTINGS
            if (headless) {

                options.addArguments("--headless=new");

                // IMPORTANT FOR HEADLESS
                options.addArguments("--window-size=1920,1080");

                options.addArguments("--disable-gpu");

                options.addArguments("--disable-dev-shm-usage");

                options.addArguments("--no-sandbox");
            }

            driver.set(new ChromeDriver(options));

        }

        // =========================
        // FIREFOX
        // =========================

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (headless) {

                options.addArguments("--headless");

                // Firefox Window Size
                options.addArguments("--width=1920");

                options.addArguments("--height=1080");
            }

            driver.set(new FirefoxDriver(options));

        }

        // =========================
        // INVALID BROWSER
        // =========================

        else {

            throw new RuntimeException("Invalid Browser Name: " + browser);
        }

        // Maximize only for non-headless
        if (!headless) {
            getDriver().manage().window().maximize();
        }

        // Optional
        // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Quit Driver
    public static void quitDriver() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
        }
    }
}