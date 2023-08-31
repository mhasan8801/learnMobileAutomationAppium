package apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.time.Duration;

public class SwipeHorizontally {

    public static void main(String[] args) {

        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click swipe page
        appiumDriver.findElementByAccessibilityId("Swipe").click();

        //3. Make sure I'm on the target screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 300L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));

        //4. Get the mobile screen sizes
        Dimension windowsSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowsSize.getHeight();
        int screenWidth = windowsSize.getWidth();

        //5. Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        //6. Perform the touch actions
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);

        //Scroll from right to left direction
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release()
                .perform();

        //Scroll from left to right direction
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint).release()
                .perform();

    }

}
