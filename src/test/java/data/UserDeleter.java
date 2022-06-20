package data;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserDeleter {

    //DELETE has to be used
    String toDeleteURL = "https://stellarburgers.nomoreparties.site/api/auth/user";
    //POST has to be used
    String toLoginURL = "https://stellarburgers.nomoreparties.site/api/auth/login";

    @Step("step is intended to delete a user")
    public void deleteUser(String email, String password) {

        //create a future request body with necessary credentials inside
        String body = String.format("{%n\"email\": \"%s\",%n\"password\": \"%s\"%n}", email, password);

        //execute POST request in order to get a user's access token
        String extractedAccessToken = given().header("Content-type", "application/json")
                .and().body(body)
                .when().post(toLoginURL).then().extract().path("accessToken");

        //using a user's access token to delete the user, and check a successful status code
        ValidatableResponse response = given().header("Authorization", extractedAccessToken)
                .header("Content-type", "application/json")
                .when().delete(toDeleteURL).then().assertThat().statusCode(202);
    }
}