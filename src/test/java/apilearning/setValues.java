package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class setValues {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click login page
        MobileElement loginPage = appiumDriver.findElementByAccessibilityId("Login");
        loginPage.click();

        //3. Input email in email field
        MobileElement emailField = appiumDriver.findElementByAccessibilityId("input-email");
        emailField.sendKeys("mhasannn@sans.com");

        //4. Input password in password field
        MobileElement passwordField = appiumDriver.findElementByAccessibilityId("input-password");
        passwordField.sendKeys("12345678");

        //5. Click on login page
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();


    }

}
