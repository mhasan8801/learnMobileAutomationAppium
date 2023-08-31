package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class HandleToggleButton {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click form page
        MobileElement formPage = appiumDriver.findElementByAccessibilityId("Forms");
        formPage.click();

        //3. Get the toggle label value before interacting with the switch
        MobileElement switchToggle = appiumDriver.findElementByAccessibilityId("switch-text");
        System.out.println("Label switch button text before interacting toggle button: " + switchToggle.getText());

        //4. Click on the toggle button
        MobileElement toggleBtn = appiumDriver.findElementByAccessibilityId("switch");
        toggleBtn.click();

        //5. Get the toggle label value before interacting with the switch
        System.out.println("Label switch button text before interacting toggle button: " + switchToggle.getText());

    }

}
