package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import utils.AppiumDriverEx;

public class setValuesWithPOM {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click login page
        MobileElement clickLoginPage = appiumDriver.findElementByAccessibilityId("Login");
        clickLoginPage.click();

        //3. Input email in email field
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.username().sendKeys("mhasannn@sans.com");

        //4. Input password in password field
        loginPage.password().sendKeys("12345678");

        //5. Click on login page
        loginPage.loginBtn().click();


    }

}
