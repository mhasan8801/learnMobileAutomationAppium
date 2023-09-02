package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageMethodChaining {

    private AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSelById = MobileBy.AccessibilityId("button-LOGIN");

    public LoginPageMethodChaining(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public MobileElement username() {
        return appiumDriver.findElement(usernameSelById);
    }

    public LoginPageMethodChaining inputUsername(String usernameText){
        this.username().sendKeys(usernameText);
        return this;
    }

    public MobileElement password() {
        return appiumDriver.findElement(passwordSelById);
    }

    public LoginPageMethodChaining inputPassword(String passwordText){
        this.password().sendKeys(passwordText);
        return this;
    }

    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSelById);
    }

    public void clickLoginBtn(){
        this.loginBtn().click();
    }
}
