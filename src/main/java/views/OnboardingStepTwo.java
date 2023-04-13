package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepTwo {
    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[1][@text =\"What’s your currency?\"]")
    private MobileElement onboardingStepTwoView;
    @AndroidFindBy(xpath = "//android.view.View[@index = 1]")
    private MobileElement currencySelector;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement currencyField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Swiss franc']")
    private MobileElement neededCurrency;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;
    public OnboardingStepTwo(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean onboardingStepTwoViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(onboardingStepTwoView)).isDisplayed();
    }
    public void selectCurrencyField(){currencySelector.click();}
    public void fillCurrencyField(String currency) {currencyField.sendKeys(currency);}
    public void chooseCurrency(){neededCurrency.click();}
    public void continueStep(){continueButton.click();}
}
