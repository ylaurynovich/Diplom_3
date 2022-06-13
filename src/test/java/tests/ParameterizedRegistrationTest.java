package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import model.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.visible;
import static data.UserDataGenerator.getGeneratedUser;


public class ParameterizedRegistrationTest extends BaseTest {

    static Stream<Arguments> loginTest() {
        return Stream.of(
                Arguments.of(
                        getGeneratedUser(6, 20), app.loginPage.getH2Enter()),
                Arguments.of(
                        getGeneratedUser(1, 5), app.registrationPage.getInvalidPasswordMessage())
        );
    }

    @ParameterizedTest
    @MethodSource
    @Description("Parameterized login test (for practise)")
    public void loginTest(User user, SelenideElement element) {
        app.registrationPage.open();
        app.registrationPage.fillRegistrationForm(user);
        element.shouldBe(visible);
    }
}