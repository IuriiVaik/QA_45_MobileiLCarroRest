package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen {

    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }


    @FindBy(id = "com.telran.ilcarro:id/editRegName")
    AndroidElement inputName;

    @FindBy(id = "com.telran.ilcarro:id/editRegLastName")
    AndroidElement inputLastName;

    @FindBy(id = "com.telran.ilcarro:id/editRegEmail")
    AndroidElement inputEmail;

    @FindBy(id = "com.telran.ilcarro:id/editRegPassword")
    AndroidElement inputPassword;

    @FindBy(id = "com.telran.ilcarro:id/checkBoxAgree")
    AndroidElement checkBox;

    @FindBy(id = "com.telran.ilcarro:id/regBtn")
    AndroidElement btnYalla;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup")
    AndroidElement registrationSuccess;

    // Методы для ввода данных
    public RegistrationScreen enterName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public RegistrationScreen enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationScreen enterEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public RegistrationScreen enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }


    public RegistrationScreen agreeToTerms() {
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        return this;
    }


    public RegistrationScreen submitRegistration() {
        btnYalla.click();
        return this;
    }


public boolean isWelcomeMessageDisplayed() {
    try {

        return registrationSuccess.isDisplayed();
    } catch (Exception e) {

        return false;
    }
}
}