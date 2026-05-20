package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	static {
		properties = new Properties();

		try {

			FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") +
				"/src/test/resources/config/config.properties"
			);



			properties.load(file);

		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	public static Properties getProperties() {
		return properties;
	}

	public static String getUrl() {
		return properties.getProperty("url");
	}
	
	public static String getUsername() {
		return getProperties().getProperty("username");
	}
	
	public static String getPassword() {
		return getProperties().getProperty("password");
	}

	public static String getBrowser() {
		return properties.getProperty("browser");
	}

	public static String getHeadless() {
		return properties.getProperty("headless");
	}
}