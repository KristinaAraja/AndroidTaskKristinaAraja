package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepThree {
    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[1][@text =\"Where would you like to go?\"]")
    private MobileElement onboardingStepThreeView;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Europe')]")
    private MobileElement destination;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Explore the app']/following-sibling::android.widget.Button")
    private MobileElement exploreAppButton;
    public OnboardingStepThree(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean onboardingStepThreeViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(onboardingStepThreeView)).isDisplayed();
    }
    public void pickDestination(){destination.click();}
    public void continueStep(){continueButton.click();}
    public void clickExploreTheApp(){exploreAppButton.click();}
}
