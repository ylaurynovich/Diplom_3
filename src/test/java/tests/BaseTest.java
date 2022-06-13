package tests;


import config.App;
import config.Driver;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {
    static App app = new App();

    @BeforeAll
    @Description("Initialization driver")
    public static void setUp(){
        Driver.initDriver();
    }

    @AfterAll
    @Description("Close browser")
    public static void TearDown(){
        closeWebDriver();
    }

}