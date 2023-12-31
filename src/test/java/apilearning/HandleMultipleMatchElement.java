package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.util.List;

public class HandleMultipleMatchElement {

    public static void main(String[] args) {

        //start an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on Login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //Find elements those are matched //*[@text="Login"]

        //Fluent wait
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@text='Login']"), 2));

        //Handle multiple match element, example text:Login
        List<MobileElement> loginTextElements = appiumDriver.findElementsByXPath("//*[@text='Login']");
        final int LOGIN_TEXT_FORM_INDEX = 0;
        final int LOGIN_MENU_TEXT_INDEX = 1;
        loginTextElements.get(LOGIN_TEXT_FORM_INDEX).click();
        loginTextElements.get(LOGIN_TEXT_FORM_INDEX).getText();

//        System.out.println("How many elements matched: " + loginTextElements.size());
//
//        MobileElement firstLoginTextElement = appiumDriver.findElementByXPath("//*[@text='Login']");
//        firstLoginTextElement.click();
    }
}
