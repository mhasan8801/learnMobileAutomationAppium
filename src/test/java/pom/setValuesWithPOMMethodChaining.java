package pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import models.pages.LoginPageMethodChaining;
import utils.AppiumDriverEx;

public class setValuesWithPOMMethodChaining {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click login page
        MobileElement clickLoginPage = appiumDriver.findElementByAccessibilityId("Login");
        clickLoginPage.click();

        //3. Input credential and click login button
        LoginPageMethodChaining loginPage = new LoginPageMethodChaining(appiumDriver);
        loginPage
                .inputUsername("username")
                .inputPassword("123")
                .clickLoginBtn();

    }

}
