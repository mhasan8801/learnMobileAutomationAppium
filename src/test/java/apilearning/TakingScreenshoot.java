package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriverEx;

import java.io.File;
import java.io.IOException;

public class TakingScreenshoot {

    public static void main(String[] args) throws IOException {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click form page
        MobileElement formPage = appiumDriver.findElementByAccessibilityId("Forms");
        formPage.click();

        //3. Click on toggle button if it's OFF
        MobileElement toggleBtn = appiumDriver.findElementByAccessibilityId("switch");
        MobileElement switchToggle = appiumDriver.findElementByAccessibilityId("switch-text");
        final boolean isToggleOn = switchToggle.getText().equals("Click to turn the switch OFF");
        if (!isToggleOn) {
            toggleBtn.click();
        }

        //4. Click on dropdown menu -> select the first option
        MobileElement dropdownField = appiumDriver.findElementByXPath("//*[@text='Select an item...']");
        dropdownField.click();
        MobileElement dropdown1 = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        dropdown1.click();

        //5. Taking a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formsScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
