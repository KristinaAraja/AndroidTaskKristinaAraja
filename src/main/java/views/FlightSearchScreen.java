package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class FlightSearchScreen {
    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Travel\"]/android.widget.TextView")
    private MobileElement flightSearchScreenSelector;
    @AndroidFindBy(xpath = "//android.widget.TextView[1][contains(@text, 'From:')]/following-sibling::android.widget.TextView")
    private MobileElement fromField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bookings']")
    private MobileElement bookingsTab;

    public FlightSearchScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean flightSearchScreenViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(flightSearchScreenSelector)).isDisplayed();
    }
    public String getFieldInfo(){return fromField.getText();}
    public void clickBookingsTab(){bookingsTab.click();}

}
