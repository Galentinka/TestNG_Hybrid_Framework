package TestCases;

import Pages.LandingPage;
import Pages.RegisterPage;
import Pages.SuccessfullyRegisterPage;
import TestBase.TestBase;
import Utilities.Utils;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    public WebDriver driver;
    public LandingPage landingPage;
    public RegisterPage registerPage;
    public SuccessfullyRegisterPage successfullyRegisterPage;

    public RegisterTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void setup() {

        driver = initializeBrowser(properties.getProperty("browser"));
        landingPage = new LandingPage(driver);
        registerPage = landingPage.navigateDirectlyToRegisterPage();
    }

    @Test(priority = 1)
    public void verifyRegisterWithMandatoryDetails() {

        successfullyRegisterPage = registerPage.directlyToSuccessfullyRegisterPage(dataProperties.getProperty("firstName"), dataProperties.getProperty("lastName"), Utils.emailWithDateStamp(), dataProperties.getProperty("phone"), dataProperties.getProperty("password"), dataProperties.getProperty("confirmPassword"));
        Assert.assertTrue(successfullyRegisterPage.successfullyRegistered());
    }

    @Test(priority = 2)
    public void verifyRegisterWithAllDetails() {

        successfullyRegisterPage = registerPage.directlyToSuccessfullyRegisterPageAllFields(dataProperties.getProperty("firstName"), dataProperties.getProperty("lastName"), Utils.emailWithDateStamp(), dataProperties.getProperty("phone"), dataProperties.getProperty("password"), dataProperties.getProperty("confirmPassword"));
        Assert.assertTrue(successfullyRegisterPage.successfullyRegistered());
    }

    @Test(priority = 3)
    public void verifyRegisterWithExistingEmail() {

        registerPage.directlyToSuccessfullyRegisterPageAllFields(dataProperties.getProperty("firstName"), dataProperties.getProperty("lastName"), properties.getProperty("validEmail"), dataProperties.getProperty("phone"), dataProperties.getProperty("password"), dataProperties.getProperty("confirmPassword"));
        Assert.assertTrue(registerPage.existingEmailWarning().contains(dataProperties.getProperty("existingEmailWarning")));
    }

    @Test(priority = 4)
    public void verifyRegisterWithIncorrectConfirmPassword() {

        registerPage.directlyToSuccessfullyRegisterPageAllFields(dataProperties.getProperty("firstName"), dataProperties.getProperty("lastName"), Utils.emailWithDateStamp(), dataProperties.getProperty("phone"), dataProperties.getProperty("password"), dataProperties.getProperty("incorrectConfirmPassword"));
        Assert.assertTrue(registerPage.displayIncorrectConfirmPasswordWarning());
    }

    @Test(priority = 5)
    public void verifyRegisterWithNoDetails() {

        registerPage.clickOnContinueButton();

        Assert.assertTrue(registerPage.privacyPolicyWarning().contains(dataProperties.getProperty("privacyPolicyWarning")));
        Assert.assertTrue(registerPage.displayFirstNameWarning());
        Assert.assertTrue(registerPage.displayEmailWarning());
        Assert.assertTrue(registerPage.displayPhoneWarning());
        Assert.assertTrue(registerPage.displayPasswordWarning());

//        throw new SkipException("Skipping this test due to a condition.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
