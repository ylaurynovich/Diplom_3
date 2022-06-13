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
        this.mainPage = page(new MainPage());
        this.headerPage = page(new HeaderPage());
        this.registrationPage = page(new RegistrationPage());
        this.loginPage = page(new LoginPage());
        this.profilePage = page(new ProfilePage());
        this.forgotPasswordPage = page(new ForgotPasswordPage());
        this.constructorPage = page(new ConstructorPage());
    }
}