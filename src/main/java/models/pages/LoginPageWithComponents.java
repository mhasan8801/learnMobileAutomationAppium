package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.authentication.credentialForm;
import org.openqa.selenium.By;

public class LoginPageWithComponents {

    private AppiumDriver<MobileElement> appiumDriver;
    private credentialForm credentialForm;
    private final By loginBtnSelById = MobileBy.AccessibilityId("button-LOGIN");

    public LoginPageWithComponents(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        credentialForm = new credentialForm(appiumDriver);
    }

    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSelById);
    }

    public void clickLoginBtn(){
        this.loginBtn().click();
    }

    public credentialForm credentialForm(){
        return this.credentialForm;
    }

}
