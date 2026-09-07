package romanmonterrosa.atlassian.net.restassured.config;

/**
 * Class loader for the api request calls paths and url.
 */
public class Settings {

	/**
	 * Private constructor to avoid instances of this class.
	 */
	private Settings() {
		throw new UnsupportedOperationException("Cannot instantiate RequestProperty class.");
	}

	/**
	 * Settings constants.
	 */
	public static final String URL = "https://automationexercise.com";
}
