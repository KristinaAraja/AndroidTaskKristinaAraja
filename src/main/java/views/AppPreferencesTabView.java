package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class AppPreferencesTabView {
    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"App preferences\"]")
    private MobileElement appPreferencesViewSelector;
    @AndroidFindBy(xpath = "//android.widget.TextView[1][@text = 'Currency']")
    private MobileElement currencySelector;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement currencyField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Swiss franc']")
    private MobileElement neededCurrency;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView")
    private MobileElement preferredCurrency;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Default departure location']")
    private MobileElement defaultDepartureSelector;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    private MobileElement clearDeparturesButton;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement departureField;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\'Add destination\'])[1]")
    private MobileElement addDestinationButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Choose']/following-sibling::android.widget.Button")
    private MobileElement chooseDestinationButton;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View/android.widget.TextView")
    private MobileElement preferredDepartureLocation;

    public AppPreferencesTabView (AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean preferencesTabViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(appPreferencesViewSelector)).isDisplayed();
    }
    public void setPreferredCurrency(){currencySelector.click();}
    public void fillCurrencyField(String currency) {currencyField.sendKeys(currency);}
    public void chooseCurrency(){neededCurrency.click();}
    public String checkCurrency(){return preferredCurrency.getText();}
    public void setDefaultDeparture(){defaultDepartureSelector.click();}
    public void clearAllLocations(){clearDeparturesButton.click();}
    public void fillDefaultDeparture(String defaultDepartureLocation){departureField.sendKeys(defaultDepartureLocation);}
    public void setAddDestination() {addDestinationButton.click();}
    public void chooseDestination() {chooseDestinationButton.click();}
    public String checkPreferredDepartureLocation(){return preferredDepartureLocation.getText();}

}
