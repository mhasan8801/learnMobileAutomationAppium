package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipeAction {

    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;


    public SwipeAction(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        touchAction = new TouchAction(this.appiumDriver);

        //4. Get the mobile screen sizes
        Dimension windowsSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowsSize.getHeight();
        int screenWidth = windowsSize.getWidth();

        //5. Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        //6. Perform the touch actions
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
    }

    public void swipeFromLeftToRight(int times){
        for (int initTime = 0; initTime < times; initTime++){
            this.swipeFromLeftToRight();
        }
    }

    public void swipeFromRightToLeft(int times){
        for (int initTime = 0; initTime < times; initTime++){
            this.swipeFromRightToLeft();
        }
    }

    public void swipeFromLeftToRight(){
        //Swipe from left to right direction
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint).release()
                .perform();
    }

    public void swipeFromRightToLeft(){
        //Swipe from right to left direction
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release()
                .perform();
    }

}
