package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.awt.*;
import java.time.Duration;

public class SwipeVertically {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click form page
        appiumDriver.findElementByAccessibilityId("Forms").click();

        //3. Make sure I'm on the target screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 300L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByAccessibilityId("switch-text")));

        //4. Get the mobile screen sizes
        Dimension windowsSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowsSize.getHeight();
        int screenWidth = windowsSize.getWidth();

        //5. Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = xStartPoint;
        int yStartPoint = 90 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        //6. Perform the touch actions
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);

        //Scroll up - Swipe from bottom to top
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release()
                .perform();

        //Scroll down - Swipe from top to bottom
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint).release()
                .perform();

    }

}
