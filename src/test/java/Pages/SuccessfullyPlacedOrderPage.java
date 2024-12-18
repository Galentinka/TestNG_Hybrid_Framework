package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfullyPlacedOrderPage {

    public WebDriver driver;

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    private WebElement yourOrderHasBeenPlaced;

    @FindBy(css = "a.btn.btn-primary")

    private WebElement continueButton;

    public SuccessfullyPlacedOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean successfullyCheckedOut() {
        return yourOrderHasBeenPlaced.isDisplayed();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
