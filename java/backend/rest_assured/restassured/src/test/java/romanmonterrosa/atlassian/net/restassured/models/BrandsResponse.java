package romanmonterrosa.atlassian.net.restassured.models;

import java.util.List;

/**
 * Record class representing the JSON response.
 * BrandsResponse Representation of the response.
 * @param responseCode Response code key.
 * @param brands Brands key, as a list.
 */
public record BrandsResponse (
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