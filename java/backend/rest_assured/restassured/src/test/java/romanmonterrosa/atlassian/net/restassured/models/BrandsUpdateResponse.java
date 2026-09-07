package romanmonterrosa.atlassian.net.restassured.models;

/**
 * Record class representing the JSON response.
 * BrandsUpdateResponse Representation of the response.
 * @param responseCode responseCode key.
 * @param message messsage key.
 */
public record BrandsUpdateResponse (
	int responseCode,
	String message
) {}
