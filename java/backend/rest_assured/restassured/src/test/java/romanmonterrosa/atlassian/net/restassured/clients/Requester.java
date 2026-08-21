package romanmonterrosa.atlassian.net.restassured.clients;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import romanmonterrosa.atlassian.net.restassured.config.RequestProperty;
import romanmonterrosa.atlassian.net.restassured.config.RequestProperty.Property;

/**
 * Requester class to handle requests.
 */
public class Requester {
	
	/**
	 * Request properties.
	 */
	private final RequestSpecification request;
	private String path;
	
	/**
	 * Constructor for a requester. Open APIS not requiring an access token.
	 * @param path The path to send the requests.
	 */
	public Requester(String path) {
		this.path = path;
		this.request = RestAssured.given()
				.baseUri(RequestProperty.getProperty(Property.URL))
				.contentType(ContentType.JSON)
				.log().ifValidationFails();
	}
	
	/**
	 * Constructor for a requester. It provides an access token for authorization.
	 * @param path The path to send the requests.
	 * @param accessToken The access token for authorization.
	 */
	public Requester(String path, String accessToken) {
		this(path);
		this.request.header(new Header("Authorization", "Bearar " + accessToken));
	}

	/**
	 * Performs a GET request in the configured path, providing the request {@code queryParams}.  
	 * @param queryParams The query parameters for this request.
	 * @return A {@link Response} object for this request.
	 */
	public Response get(Map<String, Object> queryParams) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (queryParams != null && !queryParams.isEmpty()) {
			specification.queryParams(queryParams);
		}
		return specification.get(this.path);
	}
	
	/**
	 * Performs a POST request in the configured path, providing the request {@code body}.
	 * @param body The body to send in the request.
	 * @return A {@link Response} object for this request.
	 */
	public Response post(String body) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (body != null) {
			specification.body(body);
		}
		return specification.post(this.path);
	}
	
	/**
	 * Performs a PUT request in the configured path, providing the request {@code body}
	 * @param body The body to send in the request.
	 * @return A {@link Response} object for this request.
	 */
	public Response put(String body) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (body != null) {
			specification.body(body);
		}
		return specification.put(this.path);
	}
	
	/**
	 * Performs a DELETE request in the configured path.
	 * @return A {@link Response} object for this request.
	 */
	public Response delete() {
		return RestAssured.given().spec(this.request).delete(this.path);
	}
	
	/**
	 * Factory method to create a request for the brands endpoint.
	 * @return A {@link Requester} with the brands path configured.
	 */
	public static Requester brandsRequest() {
		return new Requester(RequestProperty.getProperty(Property.BRANDS_PATH));
	}
	
	/**
	 * Factory method to create a request for the login endpoint.
	 * @return A {@link Requester} with the login path configured.
	 */
	public static Requester loginRequest() {
		return new Requester(RequestProperty.getProperty(Property.LOGIN_PATH));
	}
	
	/**
	 * Factory method to create a request for the products endpoint.
	 * @return A {@link Requester} with the products path configured.
	 */
	public static Requester productsRequest() {
		return new Requester(RequestProperty.getProperty(Property.PRODUCTS_PATH));
	}
	
	/**
	 * Factory method to create a request for the search endpoint.
	 * @return A {@link Requester} with the search path configured.
	 */
	public static Requester searchRequest() {
		return new Requester(RequestProperty.getProperty(Property.SEARCH_PATH));
	}
}
