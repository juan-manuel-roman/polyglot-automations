package romanmonterrosa.atlassian.net.restassured.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class loader for the api request calls paths and url.
 */
public class RequestProperty {
	
	/**
	 * Request properties loader.
	 */
	private static final Properties requestProperties = new Properties();

	/**
	 * Enumerator to map the properties with their key values. 
	 */
	public enum Property {
		URL,
		BRANDS_PATH,
		LOGIN_PATH,
		PRODUCTS_PATH,
		SEARCH_PATH,
		CREATE_USER_PATH,
		DELETE_USER_PATH,
		UPDATE_USER_PATH,
		GET_USER_PATH
	}
	
	private RequestProperty() {
		throw new UnsupportedOperationException("Cannot instantiate RequestProperty class.");
	}
	
	static {
		try (InputStream propertiesFile = new FileInputStream("api.properties")) {
			requestProperties.load(propertiesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a property value using the Property enumerator as a map reference.
	 * @param property The property to get.
	 * @return The property stored value.
	 */
	public static String getProperty(Property property) {
		return requestProperties.getProperty(property.name());
	}
}
