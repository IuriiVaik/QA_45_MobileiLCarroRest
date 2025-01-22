package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @BeforeMethod
    public void beforeTest() {

        new SplashScreen(driver);
        new SearchScreen(driver).goToRegistrationScreen();
    }

    @Test
    public void registrationPositiveTest() {

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);

       //Generation rondom
        int i = new Random().nextInt(10000) + 1000;
        String Name = "Harry" + i;
        String LastName = "Potter" + i;
        String Email = "harry" + i + "@example.com";


        registrationScreen
                .enterName(Name)
                .enterLastName(LastName)
                .enterEmail(Email)
                .enterPassword("StrongPass123!")
                .agreeToTerms()
                .submitRegistration();


       boolean isWelcomeMessageDisplayed = registrationScreen.isWelcomeMessageDisplayed();


         Assert.assertTrue(isWelcomeMessageDisplayed);
    }
}