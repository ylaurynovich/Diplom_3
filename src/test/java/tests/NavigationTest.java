package tests;


import data.UserClient;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class NavigationTest extends BaseTest{

    static UserClient userClient = new UserClient();
    static User user;
    private static String accessToken;
    static String login;
    static String password;

    @Before
    @Description("User registration and login")
    public void registrationUserAndLogin() {
        user = getGeneratedUser(6, 20);
        login = user.email;
        password = user.password;
        Response response = userClient.createUser(user);
        accessToken = response.path("accessToken");
        app.mainPage.open();
        app.mainPage.clickLoginButton();
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @Test
    @Description ("User registration and login")
    public void goToProfilePageTest(){
        app.headerPage.clickPersonalArea();
        app.profilePage.getProfileLink().shouldBe(visible);
    }

    @Test
    @Description ("Go to constructor from profile page")
    public void goToConstructorFromProfileTest(){
        app.headerPage.clickPersonalArea();
        app.profilePage.getProfileLink().shouldBe(visible);
        app.headerPage.clickConstructor();
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @Test
    @Description ("Go to constructor from profile page by click logo")
    public void goToConstructorFromProfileClickLogoTest(){
        app.headerPage.clickPersonalArea();
        app.profilePage.getProfileLink().shouldBe(visible);
        app.headerPage.clickLogo();
        app.mainPage.getMakeOrderButton().shouldBe(visible);
    }

    @After
    @Description ("Logout")
    public void userLogOut(){
        app.profilePage.open();
        app.profilePage.clickLogOutLink();
    }

    @AfterClass
    @Description ("Remove user")
    public static void userRemoval(){
        if (accessToken != null) userClient.deleteUser(accessToken);
    }

}