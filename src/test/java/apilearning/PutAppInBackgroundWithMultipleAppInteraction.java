package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.time.Duration;

public class PutAppInBackgroundWithMultipleAppInteraction {

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

        //put the app in background (simulate the way user press HOME button on phone) for 3 seconds
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

        //Open the settings application -> com.android.settings
        appiumDriver.activateApp("com.android.settings");

        //Go to network & internet
        appiumDriver.findElementByXPath("//*[@text='Network & internet']").click();

        //Go to internet
        appiumDriver.findElementByXPath("//*[@text='Internet']").click();

        //Go to wifi buttoon
        appiumDriver.findElementByXPath("//*[@text='Wi-Fi']").click();
        appiumDriver.findElementByXPath("//*[@text='Wi-Fi']").click();


        //RE-LAUNCH the testing app again
        appiumDriver.activateApp("com.wdiodemoapp");

        //Continue the interact with other elements on the app
        appiumDriver.findElementByXPath("//*[@text='OK']").click();


    }

}
