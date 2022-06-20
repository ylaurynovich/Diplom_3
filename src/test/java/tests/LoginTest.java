package tests;

import data.UserClient;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class LoginTest extends BaseTest {

    static UserClient userClient = new UserClient();
    static User user;
    private static String accessToken;
    static String login;
    static String password;

    @BeforeClass
    @Description("User registration")
    public static void registrationUser() throws InterruptedException {
        user = getGeneratedUser(6, 20);
        login = user.email;
        password = user.password;
        Response response = userClient.createUser(user);
        accessToken = response.path("accessToken");
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

    @After
    @Description ("Logout")
    public void userLogOut(){
        app.headerPage.clickPersonalArea();
        app.profilePage.clickLogOutLink();
    }

    @AfterClass
    @Description ("Remove user")
    public static void userRemoval(){
        if (accessToken != null) userClient.deleteUser(accessToken);
    }

}