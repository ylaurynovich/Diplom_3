package data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import model.User;


public class UserDataGenerator {

    @Step("User generating")
    public static User getGeneratedUser(Integer passwordMin, Integer passwordMax) {
        Faker faker = new Faker();
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(passwordMin, passwordMax),
                faker.name().firstName());
    }
}