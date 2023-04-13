package util;

import views.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup {

    public static AndroidDriver<MobileElement> driver;

    protected OnboardingView onboardingView;
    protected OnboardingStepOne onboardingStepOne;
    protected OnboardingStepTwo onboardingStepTwo;
    protected OnboardingStepThree onboardingStepThree;
    protected FlightSearchScreen flightSearchScreen;
    protected BookingTabView bookingTabView;
    protected Helpers helpers;
    protected ProfileTabView profileTabView;
    protected AppPreferencesTabView appPreferencesTabView;
    public DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws IOException {

        capabilities.setCapability("avd", System.getenv("device_name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/kristinaaraja/Documents/kiwi.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.skypicker.main");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver<>(new URL(GlobalVariables.localAppiumServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        helpers = new Helpers();

        onboardingView = new OnboardingView(driver);
        onboardingStepOne = new OnboardingStepOne(driver);
        onboardingStepTwo = new OnboardingStepTwo(driver);
        onboardingStepThree = new OnboardingStepThree(driver);
        flightSearchScreen = new FlightSearchScreen(driver);
        bookingTabView = new BookingTabView(driver);
        profileTabView = new ProfileTabView(driver);
        appPreferencesTabView = new AppPreferencesTabView(driver);
    }
}
