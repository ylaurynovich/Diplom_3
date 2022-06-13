package tests;

import io.qameta.allure.Description;
import model.User;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class LoginTest extends BaseTest {

    static User user;

    @BeforeAll
    @Description("User registration")
    static void registrationUser() {
        user = getGeneratedUser(6, 20);
        app.registrationPage.open();
        app.registrationPage.fillRegistrationForm(user);
        app.loginPage.getH2Enter().shouldBe(visible);

    }

    @Test
    @Description ("Login from login button main page")
    public void loginFromLoginButtonMainPageTest(){
        app.mainPage.open();
        app.mainPage.clickLoginButton();
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @Test
    @Description ("Login from personal area button")
    public void loginFromPersonalAreaButtonTest(){
        app.mainPage.open();
        app.headerPage.clickPersonalArea();
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @Test
    @Description ("Login from forgot password form")
    public void loginFromForgotPasswordFormTest(){
        app.forgotPasswordPage.open();
        app.forgotPasswordPage.clickLoginButton();
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @Test
    @Description ("Login from registration form")
    public void loginFromButtonInRegistrationForm(){
        app.registrationPage.open();
        app.registrationPage.clickLoginButton();
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @AfterEach
    @Description ("Logout")
    public void userLogOut(){
        app.headerPage.clickPersonalArea();
        app.profilePage.clickLogOutLink();
    }

}