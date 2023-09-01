package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
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
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME,"UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE," com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID,"emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, 120);

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

    public static AndroidDriver<MobileElement> getAndroidDriver(){
        //Driver instance
        AndroidDriver<MobileElement> appiumDriver = null;
        try {
            //SetDesiredCapabilities to send to appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME,"UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE," com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID,"emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, 120);

            //Set up the appium server url to connect to
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }

}
