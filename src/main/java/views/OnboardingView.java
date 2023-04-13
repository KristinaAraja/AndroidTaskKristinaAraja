package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingView {
    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(id = "com.skypicker.main:id/onboarding")
    private MobileElement onboardingView;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue as a guest']/following-sibling::android.widget.Button")
    private MobileElement continueButton;
    public OnboardingView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void clickContinueButton() {
        continueButton.click();
    }
    public boolean onboardingViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(onboardingView)).isDisplayed();
    }
}
