package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepOne {

    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[1][@text =\"Where do you start your trips?\"]")
    private MobileElement onboardingStepOneElement;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View")
    private MobileElement departurePointSelector;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement departurePointField;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\'Add destination\'])[1]")
    private MobileElement addDestinationButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Choose']/following-sibling::android.widget.Button")
    private MobileElement chooseDestinationButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;

    public OnboardingStepOne(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean onboardingStepOneViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(onboardingStepOneElement)).isDisplayed();
    }
    public void selectDeparturePoint() {departurePointSelector.click();}
    public void enterDeparturePoint(String departurePoint) {departurePointField.sendKeys(departurePoint);}
    public void setAddDestination() {addDestinationButton.click();}
    public void chooseDestination() {chooseDestinationButton.click();}
    public void continueStep(){continueButton.click();}

}
