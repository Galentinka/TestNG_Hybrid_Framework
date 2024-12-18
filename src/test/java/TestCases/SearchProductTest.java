package TestCases;

import Pages.LandingPage;
import Pages.ProductPage;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase {

    public SearchProductTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public LandingPage landingPage;
    public ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = initializeBrowser(properties.getProperty("browser"));
        landingPage = new LandingPage(driver);
    }

    @Test(priority = 1)
    public void searchWithValidProduct() {
        productPage = landingPage.navigateDirectlyToProductPage(dataProperties.getProperty("validProduct"));
        Assert.assertTrue(productPage.displayOfHPLaptop());
    }

    @Test(priority = 2)
    public void searchWitInvalidProduct() {
        productPage = landingPage.navigateDirectlyToProductPage(dataProperties.getProperty("invalidProduct"));
        Assert.assertTrue(productPage.displayWarningMessage());
    }

    @Test(priority = 3)
    public void searchWithNoProduct() {
        productPage = landingPage.clickOnSearchButton();
        Assert.assertTrue(productPage.displayWarningMessage());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
