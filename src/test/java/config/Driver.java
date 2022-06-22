package config;

import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class Driver {

    public static String browser;

    public static void initDriver() {

        if(System.getProperty("browser") == null){
            browser = "chrome";
        } else {
            browser = System.getProperty("browser");
        }
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.headless = false;

        switch (browser)
        {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeDriver driver = new ChromeDriver();
                setWebDriver(driver);
                break;

            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }
}