package TestCases;

import Pages.AccountPage;
import Pages.LandingPage;
import Pages.LoginPage;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase {

    public LoginTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public LandingPage landingPage;
    public LoginPage loginPage;
    public AccountPage accountPage;

    @BeforeMethod
    public void setup() {

        driver = initializeBrowser(properties.getProperty("browser"));
        landingPage = new LandingPage(driver);
        loginPage = landingPage.navigateDirectlyToLoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {

        accountPage = loginPage.navigateDirectlyToAccountPage(properties.getProperty("validEmail"), properties.getProperty("validPassword"));
        Assert.assertTrue(accountPage.displayStatusOfLogoutLink());
    }

    @Test(priority = 2)
    public void verifyLoginWithValidEmailInvalidPassword() {

        loginPage = new LoginPage(driver);
        loginPage.navigateDirectlyToAccountPage(properties.getProperty("validEmail"), dataProperties.getProperty("invalidPassword"));

        Assert.assertTrue(loginPage.loginWaningMessage().contains(dataProperties.getProperty("invalidLoginWarning")));
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailValidPassword() {

        loginPage = new LoginPage(driver);
        loginPage.navigateDirectlyToAccountPage(dataProperties.getProperty("invalidEmail"), properties.getProperty("validPassword"));

        Assert.assertTrue(loginPage.loginWaningMessage().contains(dataProperties.getProperty("invalidLoginWarning")));
    }

    @Test(priority = 4)
    public void loginWithInvalidCredentials() {

//        int i = 20 / 0;

        loginPage = new LoginPage(driver);

        loginPage.navigateDirectlyToAccountPage(dataProperties.getProperty("invalidEmail"), dataProperties.getProperty("invalidPassword"));

        Assert.assertTrue(loginPage.loginWaningMessage().contains(dataProperties.getProperty("invalidLoginWarning")));

    }

    @Test(priority = 5)
    public void loginWithNoCredentials() {


        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginWaningMessage().contains(dataProperties.getProperty("invalidLoginWarning")));

//        throw new SkipException("Skipping this test due to a condition.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
