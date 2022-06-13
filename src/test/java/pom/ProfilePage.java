package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ProfilePage {

    private final SelenideElement profileLink = $(byXpath("//a[text()='Профиль']"));
    private final SelenideElement logOutLink = $(byXpath("//button[text()='Выход']"));

    @Step("Open profile page")
    public void open(){
        Selenide.open("https://stellarburgers.nomoreparties.site/account");
    }

    @Step("Click logOut link")
    public void clickLogOutLink(){
        logOutLink.shouldBe(visible).click();
        logOutLink.shouldBe(disappear);
    }

    @Step("Get profile link")
    public SelenideElement getProfileLink(){
        return this.profileLink;
    }
}