package romanmonterrosa.atlassian.net.restassured.models;

import java.util.List;

/**
 * Record class representing the JSON response.
 * BrandsResponse Representation of the response.
 * @param responseCode responseCode key.
 * @param brands Brands key, as a list.
 */
public record BrandsListResponse (
    int responseCode,
    List<Brand> brands
) {
    
    /**
     * Record class representing the list of brands.
     * Brand Representation of the subList.
     * @param id Response brand id.
     * @param brand Response brand name.
     */
    public record Brand (
        int id,
        String brand
    ) {}
}