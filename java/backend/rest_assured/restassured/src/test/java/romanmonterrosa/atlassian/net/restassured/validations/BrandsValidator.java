package romanmonterrosa.atlassian.net.restassured.validations;

import io.restassured.response.Response;
import romanmonterrosa.atlassian.net.restassured.models.BrandsListResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.emptyString;

import org.hamcrest.Matchers;

/**
 * Validator class for the /api/brandsList path.
 * BrandsValidator Validates the brands list.
 */
public class BrandsValidator extends BaseValidator<BrandsValidator> {

    /**
     * The response body
     */
    private BrandsListResponse body;

    /**
     * Constructor for the class
     * @param response The response to validate.
     */
    public BrandsValidator(Response response) {
        super(response);
        this.body = this.mapResponseBody(BrandsListResponse.class);
    }

    /**
     * Validates the response code in the JSON response.
     * @param statusCode The reference status code to validate.
     * @return This object, to chain calls.
     */
    public BrandsValidator validateResponseCode(int statusCode) {
        assertThat(this.body.responseCode(), Matchers.equalTo(statusCode));
        return this;
    }

    /**
     * Validates that responseBody.brands list is not empty.
     * @return This object, to chain calls.
     */
    public BrandsValidator validateBrandsIsNotEmpty() {
        assertThat(this.body.brands(), not(empty()));
        return this;
    }

    /**
     * Validates that each responseBody.brands element is not empty or null.
     * @return This object, to chain calls.
     */
    public BrandsValidator validateEachBrandIsNotEmptyOrNull() {
        for(BrandsListResponse.Brand element : this.body.brands()) {
            assertThat(element.brand(), not(emptyString()));
            assertThat(element.brand(), notNullValue());
        }
        return this;
    }
}
