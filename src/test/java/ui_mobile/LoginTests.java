package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    LoginScreen loginScreen;

    @BeforeMethod
    public void beforeLogin(){
        new SplashScreen(driver);
        new SearchScreen(driver).goToLoginScreen();
    }

    @Test
    public void loginPositiveTest(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(
                UserDTO.builder()
                        .username("0bagginsbob@mail.com")
                        .password("Qwerty123!")
                        .build()
        );
    }

    @Test
    public void loginWithInvalidEmail() {
        loginScreen = new LoginScreen(driver);

        loginScreen.login(
                UserDTO.builder()
                        .username("invalid-email")
                        .password("Qwerty123!")
                        .build()
        );

        Assert.assertTrue(loginScreen.isErrorMessageDisplayed());
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginScreen = new LoginScreen(driver);

        loginScreen.login(
                UserDTO.builder()
                        .username("0bagginsbob@mail.com")
                        .password("WrongPassword123!")
                        .build()
        );

        Assert.assertTrue(loginScreen.isErrorMessageDisplayed());
    }

    @Test
    public void loginWithEmptyFields() {
        loginScreen = new LoginScreen(driver);

        loginScreen.login(
                UserDTO.builder()
                        .username("")
                        .password("")
                        .build()
        );

        Assert.assertTrue(loginScreen.isErrorMessageDisplayed());
    }

    @Test
    public void loginWithUnregisteredUser() {
        loginScreen = new LoginScreen(driver);

        loginScreen.login(
                UserDTO.builder()
                        .username("sftghjdtrhdrfhs@mail.com")
                        .password("Qwerty123!")
                        .build()
        );

        Assert.assertTrue(loginScreen.isErrorMessageDisplayed());
    }
}
