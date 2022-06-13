package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HeaderPage {

    private final SelenideElement logo = $(byXpath("//div[contains(@class, 'logo')]/a[@href='/']"));
    private final SelenideElement personalArea = $(byXpath("//p[text()='Личный Кабинет']"));
    private final SelenideElement constructor = $(byXpath("//p[text()='Конструктор']"));

    @Step("Click link personal area")
    public void clickPersonalArea(){
        personalArea.shouldBe(visible).click();
    }

    @Step("Click link constructor")
    public void clickConstructor(){
        constructor.shouldBe(visible).click();
    }

    @Step("Click site logo")
    public void clickLogo(){
        logo.shouldBe(visible).click();
    }

}