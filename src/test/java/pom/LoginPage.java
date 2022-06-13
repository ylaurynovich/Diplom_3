package pom;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.User;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement h2Enter = $(byXpath("//h2[text()='Вход']"));
    private final SelenideElement emailInput = $(byXpath("//label[text()='Email']/following-sibling::input"));
    private final SelenideElement passwordInput = $(byXpath("//label[text()='Пароль']/following-sibling::input"));
    private final SelenideElement buttonEnter = $(byXpath("//button[text()='Войти']"));

    @Step("Open login page")
    public void open(){
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
    }

    @Step("Fill login form")
    public void fillLoginForm(User user){
        emailInput.shouldBe(exist).setValue(user.email);
        passwordInput.shouldBe(exist).setValue(user.password);
        buttonEnter.shouldBe(exist).click();

    }
    @Step("Get h2 Enter")
    public SelenideElement getH2Enter(){
        return this.h2Enter;
    }

    @Step("Get Enter button")
    public SelenideElement getButtonEnter(){
        return this.buttonEnter;
    }
}