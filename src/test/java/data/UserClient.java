package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.User;

import static io.restassured.RestAssured.given;

public class UserClient {
    protected final String JSON = "application/json";
    private final String ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth";

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
}
