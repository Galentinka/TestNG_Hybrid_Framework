package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public WebDriver driver;

    @FindBy(id = "button-payment-address")
    private WebElement billingDetailsContinueButton;

    @FindBy(id = "button-shipping-address")
    private WebElement deliveryDetailsContinueButton;

    @FindBy(name = "comment")
    private WebElement commentDeliveryMethod;

    @FindBy(id = "button-shipping-method")
    private WebElement deliveryMethodContinueButton;

    @FindBy(name = "comment")
    private WebElement commentPaymentMethod;

    @FindBy(id = "button-payment-method")
    private WebElement paymentMethodContinueButton;

    @FindBy(name = "agree")
    private WebElement termsAndConditionRatioButton;

    @FindBy(xpath = "//input[@id='button-confirm']")
    private WebElement confirmOrderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBillingDetailsContinueButton() {
        billingDetailsContinueButton.click();
    }

    public void clickOnDeliveryDetailsContinueButton() {
        deliveryDetailsContinueButton.click();
    }

    public void commentDeliveryMethod(String Comment) {
        commentDeliveryMethod.sendKeys(Comment);
    }

    public void clickOnDeliveryMethodContinueButton() {
        deliveryMethodContinueButton.click();
    }

    public void sendCommentPaymentMethod(String Comment) {
        commentPaymentMethod.sendKeys(Comment);
    }

    public void clickOnTermsAndConditionRatioButton() {
        termsAndConditionRatioButton.click();
    }

    public void clickOnPaymentMethodContinueButton() {
        paymentMethodContinueButton.click();
    }

    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }

    public SuccessfullyPlacedOrderPage checkoutSuccessfully() throws InterruptedException {

        billingDetailsContinueButton.click();
        deliveryDetailsContinueButton.click();
        commentDeliveryMethod("Great!");
        deliveryMethodContinueButton.click();
        sendCommentPaymentMethod("No comment.");
        termsAndConditionRatioButton.click();
        paymentMethodContinueButton.click();
        Thread.sleep(5000);
        confirmOrderButton.click();

        return new SuccessfullyPlacedOrderPage(driver);
    }
}

