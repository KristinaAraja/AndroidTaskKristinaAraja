import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;
import util.GlobalVariables;

public class DeparturePreferences extends DriverSetup {
    @Test(testName = "Continue as a guest flow", groups = "onboarding")
    public void continueAsAGuestFlow() throws InterruptedException {
        Assert.assertTrue(this.onboardingView.onboardingViewLoaded(), "App onboarding view isn't loaded ");
        onboardingView.clickContinueButton();
        Thread.sleep(2000);

        Assert.assertTrue(this.onboardingStepOne.onboardingStepOneViewLoaded(), "Onboarding step 1 view isn't loaded ");
        onboardingStepOne.selectDeparturePoint();
        onboardingStepOne.enterDeparturePoint(GlobalVariables.departurePoint);
        onboardingStepOne.setAddDestination();
        onboardingStepOne.chooseDestination();
        onboardingStepOne.continueStep();

        Assert.assertTrue(this.onboardingStepTwo.onboardingStepTwoViewLoaded(), "Onboarding step 2 view isn't loaded ");
        onboardingStepTwo.selectCurrencyField();
        onboardingStepTwo.fillCurrencyField(GlobalVariables.currency);
        onboardingStepTwo.chooseCurrency();
        onboardingStepTwo.continueStep();

        Assert.assertTrue(this.onboardingStepThree.onboardingStepThreeViewLoaded(), "Onboarding step 3 view isn't loaded ");
        onboardingStepThree.pickDestination();
        onboardingStepThree.continueStep();
        onboardingStepThree.clickExploreTheApp();

        Assert.assertTrue(this.flightSearchScreen.flightSearchScreenViewLoaded(), "Flight search screen view isn't loaded ");
        Assert.assertEquals(flightSearchScreen.getFieldInfo(),GlobalVariables.departurePoint);
        flightSearchScreen.clickBookingsTab();

        Assert.assertTrue(this.bookingTabView.bookingTabViewLoaded(), "Booking tab view isn't loaded ");
        Assert.assertEquals(bookingTabView.getAccountInfo(),GlobalVariables.expectedLogInMessage);
        bookingTabView.clickProfileTab();

        Assert.assertTrue(this.profileTabView.profileTabViewLoaded(), "Profile tab view isn't loaded ");
        profileTabView.clickAppPreferencesButton();

        Assert.assertTrue(this.appPreferencesTabView.preferencesTabViewLoaded(), "App preferences view isn't loaded ");
        appPreferencesTabView.setPreferredCurrency();
        appPreferencesTabView.fillCurrencyField(GlobalVariables.currency);
        appPreferencesTabView.chooseCurrency();
        Assert.assertEquals(appPreferencesTabView.checkCurrency(),GlobalVariables.preferredCurrency);
        appPreferencesTabView.setDefaultDeparture();
        appPreferencesTabView.clearAllLocations();
        appPreferencesTabView.fillDefaultDeparture(GlobalVariables.defaultDepartureLocation);
        appPreferencesTabView.setAddDestination();
        appPreferencesTabView.chooseDestination();
        Assert.assertEquals(appPreferencesTabView.checkPreferredDepartureLocation(),GlobalVariables.defaultDepartureLocation);


    }

}
