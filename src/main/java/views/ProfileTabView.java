package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class ProfileTabView extends Helpers {

    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Notifications and support\"]")
    private MobileElement profileTabViewSelector;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App preferences']")
    private MobileElement appPreferencesButton;

    public ProfileTabView (AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean profileTabViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(profileTabViewSelector)).isDisplayed();
    }
    public void clickAppPreferencesButton() {
        scrollToElementWithText(driver, "App preferences");
        appPreferencesButton.click();
    }

}
