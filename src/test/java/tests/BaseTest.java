package tests;


import config.App;
import config.Driver;
import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {
    static App app = new App();

    @BeforeClass
    @Description("Initialization driver")
    public static void setUp(){
        Driver.initDriver();
    }

    @AfterClass
    @Description("Close browser")
    public static void TearDown(){
        closeWebDriver();
    }

}