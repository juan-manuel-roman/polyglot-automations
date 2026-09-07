package romanmonterrosa.atlassian.net.restassured.paths;

/**
 * Path class to handle constants for the paths in the app.
 */
public class Path {

    /**
     * Private constructor for the path class, to avoid instances.
     */
    private Path() {
        throw new UnsupportedOperationException("Cannot create a path instance");
    }

    /**
     * Path constatns to handle paths.
     */
    public static final String BRANDS_PATH = "/api/brandsList";
    public static final String LOGIN_PATH = "/api/verifyLogin";
    public static final String PRODUCTS_PATH = "/api/productsList";
    public static final String SEARCH_PATH = "/api/searchProduct";
    public static final String CREATE_USER_PATH = "/api/createAccount";
    public static final String DELETE_USER_PATH = "/api/deleteAccount";
    public static final String UPDATE_USER_PATH = "/api/updateAccount";
    public static final String GET_USER_PATH = "/api/getUserDetailByEmail";
}
