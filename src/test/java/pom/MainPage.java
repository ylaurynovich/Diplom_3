package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {

    private final SelenideElement loginButton = $(byXpath("//button[text()='Войти в аккаунт']"));
    private final SelenideElement makeOrderButton = $(byXpath("//button[text()='Оформить заказ']"));

    @Step("Open main page")
    public void open(){
        Selenide.open("https://stellarburgers.nomoreparties.site");
        loginButton.shouldBe(visible);
    }
    @Step("Click login button")
    public void clickLoginButton(){
        loginButton.shouldBe(visible).click();
    }

    @Step("Get make order button")
    public SelenideElement getMakeOrderButton(){
        return this.makeOrderButton;
    }

}
