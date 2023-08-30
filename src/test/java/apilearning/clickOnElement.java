package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class clickOnElement {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();
    }

}
