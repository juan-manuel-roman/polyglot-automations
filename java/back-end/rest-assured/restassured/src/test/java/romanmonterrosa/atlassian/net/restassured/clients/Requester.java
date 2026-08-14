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
public abstract class Requester {
	
	/**
	 * Request properties.
	 */
	protected RequestProperty properties;
	private final RequestSpecification request;
	
	/**
	 * Constructor for a requester. Open APIS not requiring an access token.
	 * @param props The request properties for paths and url.
	 */
	public Requester(RequestProperty props) {
		this.properties = props;
		this.request = RestAssured.given()
				.baseUri(properties.getProperty(Property.URL))
				.contentType(ContentType.JSON)
				.log().ifValidationFails();
	}
	
	/**
	 * Constructor for a requester. It provides an access token for authorization.
	 * @param props The request properties for paths and url.
	 * @param accessToken The access token for authorization.
	 */
	public Requester(RequestProperty props, String accessToken) {
		this(props);
		this.request.header(new Header("Authorization", "Bearar" + accessToken));
	}

	/**
	 * Performs a GET request in <path>, providing any <queryParams>.  
	 * @param path The path to perform the request.
	 * @param queryParams The query parameters necessary for this request.
	 * @return <Response> The response for this request.
	 */
	public Response get(String path, Map<String, Object> queryParams) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (queryParams != null && !queryParams.isEmpty()) {
			specification.queryParams(queryParams);
		}
		return specification.get(path);
	}
	
	/**
	 * Performs a POST request in <path>, providing the request <body>.
	 * @param path The path to perform the request.
	 * @param body The body to be sent in the request.
	 * @return <Response> The response for this request.
	 */
	public Response post(String path, String body) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (body != null) {
			specification.body(body);
		}
		return specification.post(path);
	}
	
	/**
	 * Performs a PUT request in <path>, providing the request <body>
	 * @param path The path to perform the request.
	 * @param body The body to be sent in the request.
	 * @return <Response> The response for this request.
	 */
	public Response put(String path, String body) {
		RequestSpecification specification = RestAssured.given().spec(this.request);
		if (body != null) {
			specification.body(body);
		}
		return specification.put(path);
	}
	
	/**
	 * Performs a DELETE request in <path>.
	 * @param path The path to perform the request.
	 * @return <Response> The response for this request.
	 */
	public Response delete(String path) {
		return RestAssured.given().spec(this.request).delete(path);
	}
	
	abstract Response get(Map<String, Object> queryParams);
	abstract Response post(String body);
	abstract Response put(String body);
	abstract Response delete();
}
