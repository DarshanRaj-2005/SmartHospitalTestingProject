package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties properties;

	public static Properties getProperties() {

		properties = new Properties();

		try {

			FileInputStream file = new FileInputStream("src\\test\\resources\\config\\config.properties");

			properties.load(file);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return properties;
	}
	
	public static String getUrl() {
		return getProperties().getProperty("url");
	}
	
	public static String getUsername() {
		return getProperties().getProperty("username");
	}
	
	public static String getPassword() {
		return getProperties().getProperty("password");
	}

}
