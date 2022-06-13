package tests;

import io.qameta.allure.Description;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class RegistrationTest extends BaseTest {

    @BeforeEach
    public void openRegistrationPage(){
        app.registrationPage.open();
    }

    @Test
    @Description("Login")
    public void loginTest() {
        User user = getGeneratedUser(6, 20);
        app.registrationPage.fillRegistrationForm(user);
        app.loginPage.getH2Enter().shouldBe(visible);
    }

    @Test
    @Description ("Login invalid password")
    public void loginWithInvalidPasswordTest() {
        User user = getGeneratedUser(1, 5);
        app.registrationPage.fillRegistrationForm(user);
        app.registrationPage.getInvalidPasswordMessage().shouldBe(visible);
    }

}