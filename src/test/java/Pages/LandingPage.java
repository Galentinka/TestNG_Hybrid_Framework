package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    @FindBy(name = "search")
    private WebElement searchTextBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccountDropdown() {
        myAccountDropdown.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public LoginPage navigateDirectlyToLoginPage() {
        myAccountDropdown.click();
        loginButton.click();

        return new LoginPage(driver);
    }

    public RegisterPage navigateDirectlyToRegisterPage() {
        myAccountDropdown.click();
        registerButton.click();

        return new RegisterPage(driver);
    }

    public void enterProduct(String product) {
        searchTextBox.sendKeys(product);
    }

    public ProductPage clickOnSearchButton() {
        searchButton.click();
        return new ProductPage(driver);
    }

    public ProductPage navigateDirectlyToProductPage(String product) {
        searchTextBox.sendKeys(product);
        searchButton.click();

        return new ProductPage(driver);
    }

}
