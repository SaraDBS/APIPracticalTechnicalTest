package APITechnicalTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PetStoreTest {

    @Before
    public void setBaseUrl() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }

    @Test
    public void createAndReturnPet() {

        String response = given().
                queryParam("key", "special-key").
                body(PetPayload.getPostBody()).
                and().contentType(ContentType.JSON).
                when().
                log().
                all().
                post().
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .extract()
                .response().asString();


        JsonPath jsonPath = new JsonPath(response);
        String petId = String.valueOf(jsonPath.get("id"));
        given().
                queryParam("key", "special-key").
                get(PetStoreResources.readPetId().replace("{petId}", petId)).
                then().assertThat().
                statusCode(200).
                and().body("status", equalTo("available")).
                and().body("id", equalTo(5)).
                and().body("name", equalTo("Ruby"));
    }


    @Test
    public void updateAndVerifyPet() {

        Response response = given().
                queryParam("key", "special-key").
                body(PetPayload.getPutBody()).
                and().contentType(ContentType.JSON).
                when().
                log().
                all().
                put().
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .extract()
                .response();

        String petId = String.valueOf(rawToJson(response).get("id"));

        given().
                queryParam("key", "special-key").
                get(PetStoreResources.readPetId().replace("{petId}", petId)).
                then().assertThat().
                statusCode(200).
                and().body("name", equalTo("Lola"));
    }

    @Test
    public void deleteAndVerifyPetDeleted() {

        given().
                queryParam("key", "special-key").
                delete(PetStoreResources.readPetId().replace("{petId}", "5")).
                then().assertThat().
                statusCode(200);

        given().
                queryParam("key", "special-key").
                get(PetStoreResources.readPetId().replace("{petId}", "5")).
                then().assertThat().
                statusCode(404);

    }

    private static JsonPath rawToJson(Response response) {
        String stringResponse = response.asString();
        return new JsonPath(stringResponse);
    }
}

