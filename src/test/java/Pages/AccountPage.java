package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public WebDriver driver;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[normalize-space()='Qafox.com']")
    private WebElement quafoxLink;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayStatusOfLogoutLink() {
        return logoutLink.isDisplayed();
    }

    public LandingPage clickOnQuafoxLink() {
        quafoxLink.click();

        return new LandingPage(driver);
    }
}
