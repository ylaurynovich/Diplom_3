package tests;


import io.qameta.allure.Description;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class NavigationTest extends BaseTest{

    @BeforeEach
    @Description("User registration and login")
    public void registrationUserAndLogin() {
        User user = getGeneratedUser(6, 20);
        app.registrationPage.open();
        app.registrationPage.fillRegistrationForm(user);
        app.loginPage.getH2Enter().shouldBe(visible);
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(exist);

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

    @AfterEach
    @Description ("Logout")
    public void userLogOut(){
        app.profilePage.open();
        app.profilePage.clickLogOutLink();
    }

}