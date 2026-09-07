package romanmonterrosa.atlassian.net.restassured.validations;

import io.restassured.response.Response;
import romanmonterrosa.atlassian.net.restassured.utils.StatusCodes;

import static org.hamcrest.Matchers.equalTo;

/**
 * Base validation class for the responeses.
 * BaseValidator Base class that uses the Curiously Recurring Template Pattern.
 * @param <T> The generic parameter that extends itself. Will work as a builder to chain calls.
 */
public class BaseValidator <T extends BaseValidator<T>> {
	
    /**
     * The response to be validated.
     */
    protected final Response response;

    /**
     * Base validator constructor.
     * @param response The response to be validated.
     */
    public BaseValidator(Response response) {
        this.response = response;
    }

    /**
     * Validates the response status code.
     * @param expectedCode The status code to validate.
     * @return A reference to this object, to create a builder.
     */
    @SuppressWarnings("unchecked")
    public T validateStatusCode(int expectedCode) {
        this.response.then().statusCode(equalTo(StatusCodes.OK));
        return (T) this;
    }

    /**
     * Validates the response content type.
     * @param contentType The content type to validate.
     * @return A reference to this object, to create a builder.
     */
    @SuppressWarnings("unchecked")
    public T validateContentType(String contentType) {
        this.response.then().contentType(equalTo(contentType));
        return (T) this;
    }

    /**
     * Mapper from the response body to a record class.
     * @param <R> The type of the class to be returned.
     * @param referencer The class to map the response.
     * @return The mapped class object from the resonse.
     */
    public <R> R mapResponseBody(Class<R> referencer) {
        return this.response.as(referencer);
    }
}
