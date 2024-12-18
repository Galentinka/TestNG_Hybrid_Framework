package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    @FindBy(linkText = "HP LP3065")
    private WebElement HPLaptop;

    @FindBy(xpath = "//div[@class='button-group']//button[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
    private WebElement productWarning;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayOfHPLaptop() {
        return HPLaptop.isDisplayed();
    }

    public boolean displayWarningMessage() {
        return productWarning.isDisplayed();
    }


    public AddToCartDetailsPage navigateDetailsPage() {
        addToCartButton.click();
        return new AddToCartDetailsPage(driver);
    }
}
