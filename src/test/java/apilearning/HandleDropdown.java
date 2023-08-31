package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class HandleDropdown {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click form page
        MobileElement formPage = appiumDriver.findElementByAccessibilityId("Forms");
        formPage.click();

        //3. Click on the dropdown element
        MobileElement dropdownField = appiumDriver.findElementByXPath("//*[@text='Select an item...']");
        dropdownField.click();

        //4. Select the first option
        MobileElement dropdown1 = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        dropdown1.click();


    }

}
