package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

import java.time.Duration;

public class PutAppInBackground {

    public static void main(String[] args) {

        //init a session with appium server
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //go to log in form and input username and password
        //Click login page
        MobileElement loginPage = appiumDriver.findElementByAccessibilityId("Login");
        loginPage.click();
        //Input email in email field
        MobileElement emailField = appiumDriver.findElementByAccessibilityId("input-email");
        emailField.sendKeys("mhasannn@sans.com");
        //Input password in password field
        MobileElement passwordField = appiumDriver.findElementByAccessibilityId("input-password");
        passwordField.sendKeys("12345678");
        //Click on login page
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();
        //Get the value text from dialog window login success
        MobileElement successLoginTitle = appiumDriver.findElementById("android:id/alertTitle");
        successLoginTitle.isDisplayed();

        //put the app in background for 5 seconds
        appiumDriver.runAppInBackground(Duration.ofSeconds(3));

    }

}
