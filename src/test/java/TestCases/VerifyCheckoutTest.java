package TestCases;

import Pages.*;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyCheckoutTest extends TestBase {

    public WebDriver driver;
    public LandingPage landingpage;
    public LoginPage loginpage;
    public AccountPage accountpage;
    public ProductPage productpage;
    public AddToCartDetailsPage addToCartDetailsPage;
    public CheckoutPage checkoutPage;
    public SuccessfullyPlacedOrderPage successfullyPlacedOrderPage;

    public VerifyCheckoutTest() throws Exception {
        super();
    }

    @BeforeClass
    public void setup() {
        driver = initializeBrowser(properties.getProperty("browser"));
        landingpage = new LandingPage(driver);
        loginpage = landingpage.navigateDirectlyToLoginPage();
        accountpage = loginpage.navigateDirectlyToAccountPage(properties.getProperty("validEmail"), properties.getProperty("validPassword"));
        landingpage = accountpage.clickOnQuafoxLink();
    }

    @Test
    public void verifySuccessfulCheckout() throws InterruptedException {

        productpage = landingpage.navigateDirectlyToProductPage(dataProperties.getProperty("validProduct"));
        Assert.assertTrue(productpage.displayOfHPLaptop());
        addToCartDetailsPage = productpage.navigateDetailsPage();
        checkoutPage = addToCartDetailsPage.navigateCheckoutPage();
        successfullyPlacedOrderPage = checkoutPage.checkoutSuccessfully();
        Assert.assertTrue(successfullyPlacedOrderPage.successfullyCheckedOut());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
