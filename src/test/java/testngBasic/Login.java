package testngBasic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import models.pages.LoginPageWithComponents;
import org.testng.annotations.Test;
import utils.AppiumDriverEx;

public class Login {

    //annotations
    @Test
    public void loginWithCorrectCreds() {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click login page
        MobileElement clickLoginPage = appiumDriver.findElementByAccessibilityId("Login");
        clickLoginPage.click();

        //3. Input email in email field
        LoginPageWithComponents loginPage = new LoginPageWithComponents(appiumDriver);
        loginPage.credentialForm().inputUsername("mhasannn@sans.com");

        //4. Input password in password field
        loginPage.credentialForm().inputPassword("12345678");

        //5. Click on login page
        loginPage.clickLoginBtn();


    }

}
