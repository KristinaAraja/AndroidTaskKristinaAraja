package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class BookingTabView {
    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"My trips\"]")
    private MobileElement bookingTabViewSelector;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Sign in to your account']")
    private MobileElement accountInfo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Profile']")
    private MobileElement profileTab;

    public BookingTabView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean bookingTabViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(bookingTabViewSelector)).isDisplayed();
    }
    public String getAccountInfo(){return accountInfo.getText();}
    public void clickProfileTab(){profileTab.click();}

}
