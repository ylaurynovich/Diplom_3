package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;

public class UserClient {
    protected final String JSON = "application/json";
    private final String ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth";
    String toLoginURL = "https://stellarburgers.nomoreparties.site/api/auth/login";

    @Step("Create user")
    public Response createUser(User user) {
        return given()
                .header("Content-type", JSON)
                .and()
                .body(user)
                .when()
                .post(ENDPOINT + "/register");
    }

    @Step("Delete user")
    public Response deleteUser(String accessToken) {
        return given()
                .header("Content-type", JSON)
                .header("Authorization", accessToken)
                .delete(ENDPOINT + "/user");
    }

    @Step("Extract token after login")
    public String extractToken(String email, String password) {

        //create a future request body with necessary credentials inside
        String body = String.format("{%n\"email\": \"%s\",%n\"password\": \"%s\"%n}", email, password);

        //execute POST request in order to get a user's access token
        return given().header("Content-type", "application/json")
                .and().body(body)
                .when().post(toLoginURL).then().extract().path("accessToken");

    }
}
