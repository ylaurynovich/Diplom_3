package tests;

import io.qameta.allure.Description;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;

public class LogoutTest extends BaseTest{

    static User user;

    @BeforeEach
    @Description("User registration and login")
    public void registrationUserAndLogin() {
        user = getGeneratedUser(6, 20);
        app.registrationPage.open();
        app.registrationPage.fillRegistrationForm(user);
        app.loginPage.getH2Enter().shouldBe(visible);
        app.loginPage.fillLoginForm(user);
        app.mainPage.getMakeOrderButton().shouldBe(visible);

    }

    @Test
    @Description ("Logout")
    public void logoutTest(){
        app.profilePage.open();
        app.profilePage.clickLogOutLink();
        app.loginPage.getButtonEnter().shouldBe(exist);
    }


}