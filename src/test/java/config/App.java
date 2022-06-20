package config;

import pom.*;
import static com.codeborne.selenide.Selenide.page;


public class App {

    public MainPage mainPage;
    public HeaderPage headerPage;
    public RegistrationPage registrationPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public ForgotPasswordPage forgotPasswordPage;
    public ConstructorPage constructorPage;

    public App() {
        mainPage = page(new MainPage());
        headerPage = page(new HeaderPage());
        registrationPage = page(new RegistrationPage());
        loginPage = page(new LoginPage());
        profilePage = page(new ProfilePage());
        forgotPasswordPage = page(new ForgotPasswordPage());
        constructorPage = page(new ConstructorPage());
    }
}