package romanmonterrosa.atlassian.net.restassured.utils;

/**
 * Utility class to handle status codes.
 * StatusCodes Container of the status codes.
 */
public class StatusCodes {

    /**
     * Private constructor to avoid instances.
     */
    private StatusCodes() {
        throw new UnsupportedOperationException("Cannot create an instance of Status Codes");
    }

    /**
     * Static variables for the class.
     */
    public static final int OK = 200;
    public static final int UNSUPPORTED_OPERATION = 405;
}
