package tests;

import data.UserClient;
import io.qameta.allure.Description;
import model.User;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;
import static tests.LoginTest.userClient;


public class RegistrationTest extends BaseTest {

    private String email;
    private String password;
    private static String accessToken;


    @Before
    public void openRegistrationPage(){
        app.registrationPage.open();
    }

    @Test
    @Description("Login")
    public void loginTest() {
        User user = getGeneratedUser(6, 20);
        email = user.getEmail();
        password = user.getPassword();
        app.registrationPage.fillRegistrationForm(user);
        app.loginPage.getH2Enter().shouldBe(visible);
    }

    @Test
    @Description ("Login invalid password")
    public void loginWithInvalidPasswordTest() {
        User user = getGeneratedUser(1, 5);
        email = user.getEmail();
        password = user.getPassword();
        app.registrationPage.fillRegistrationForm(user);
        app.registrationPage.getInvalidPasswordMessage().shouldBe(visible);

    }

    @Parameterized.AfterParam
    public void afterClass() {
        accessToken = userClient.extractToken(email, password);
        if (accessToken != null) userClient.deleteUser(accessToken);
    }
}