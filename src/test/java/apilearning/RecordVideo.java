package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import utils.AppiumDriverEx;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class RecordVideo {

    public static void main(String[] args) {

        //init session with appium server
        AndroidDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        //Start recording
        ((CanRecordScreen) appiumDriver).startRecordingScreen();

        //To do something for the test to simulate real user actions
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

        //Stop recording
        String video = ((CanRecordScreen) appiumDriver).stopRecordingScreen();

        //Save the recorded data to system
        byte[] decodeVideo = Base64.getMimeDecoder().decode(video);
        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);
            //test-date.mp4
            Path testVideoFileLocation =
                    Paths.get(testVideoDir.toString(), String.format("%s-%d.%s", "test", System.currentTimeMillis(), "mp4"));
            Files.write(testVideoFileLocation, decodeVideo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
