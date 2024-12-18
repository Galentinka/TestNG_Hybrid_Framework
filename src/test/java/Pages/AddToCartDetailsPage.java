package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartDetailsPage {

    public WebDriver driver;

    @FindBy(name = "quantity")
    private WebElement quantity;

    @FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
    private WebElement addToCartButton;

    @FindBy(css = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
    private WebElement cartPreviewButton;

    @FindBy(xpath = "//strong[text()='Checkout']")
    private WebElement checkoutButton;

    public AddToCartDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeQuantity(String Quantity) {
        quantity.sendKeys(Quantity);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCartPreviewButton() {
        cartPreviewButton.click();
    }

    public CheckoutPage navigateCheckoutPage() {

        quantity.sendKeys("2");
        addToCartButton.click();
        cartPreviewButton.click();
        checkoutButton.click();

        return new CheckoutPage(driver);
    }
}
