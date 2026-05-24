package APITests;

import API.config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class APITest {

    @Test
    public void getAllProducts(){
        given()
                .when()
                .get(TestConfig.PRACTICE_SOFTWARE_TESTING + "/products")
                .then()
                .statusCode(200)
                .body("total",equalTo(50));
    }

    @Test
    public void getCategories(){
        given()
                .when()
                .get(TestConfig.PRACTICE_SOFTWARE_TESTING + "/categories")
                .then()
                .statusCode(200)
                .body("name", notNullValue());

    }

    @Test
    public void postCategory(){

        String payload =
                {
                "name": "Combination Pliers",
                "description": "Cutters",
                "price": 14.15}


    }

}
