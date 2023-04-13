package util;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Helpers {

    public void scrollToElementWithText(AndroidDriver<MobileElement> driver, String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
    }

}
