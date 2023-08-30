package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {
    public static AppiumDriver<MobileElement> getAppiumDriver(){
        //Driver instance
        AppiumDriver<MobileElement> appiumDriver = null;
        try {
            //SetDesiredCapabilities to send to appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            desiredCapabilities.setCapability("appPackage"," com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");

            //Set up the appium server url to connect to
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }

}
