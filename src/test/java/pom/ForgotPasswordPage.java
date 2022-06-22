package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final SelenideElement loginButton = $(byXpath("//a[text()='Войти']"));

    @Step("Open forgot password page")
    public void open(){
        Selenide.open(URL);
    }

    @Step("Click login button")
    public void clickLoginButton(){
        loginButton.shouldBe(exist).click();
    }

}