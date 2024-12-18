package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement phone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(name = "agree")
    private WebElement agreeButton;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement yesSubscribeRadioButton;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement existingEmailWarning;

    @FindBy(xpath = "//div[text() = 'Password confirmation does not match password!']")
    private WebElement incorrectConfirmPasswordWarning;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement privacyPolicyWarning;

    @FindBy(xpath = "//div[text() = 'First Name must be between 1 and 32 characters!']")
    private WebElement firstNameWarning;

    @FindBy(xpath = "//div[text() = 'Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameWarning;

    @FindBy(xpath = "//div[text() = 'E-Mail Address does not appear to be valid!']")
    private WebElement emailWarning;

    @FindBy(xpath = "//div[text() = 'Telephone must be between 3 and 32 characters!']")
    private WebElement phoneWarning;

    @FindBy(xpath = "//div[text() = 'Password must be between 4 and 20 characters!']")
    private WebElement passwordWarning;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstnameText) {
        firstName.sendKeys(firstnameText);
    }

    public void enterLastName(String lastnameText) {
        lastName.sendKeys(lastnameText);
    }

    public void enterEmail(String emailText) {
        email.sendKeys(emailText);
    }

    public void enterPhoneNumber(String phoneText) {
        phone.sendKeys(phoneText);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        confirmPassword.sendKeys(pass);
    }

    public void checkAgreeRatioButton() {
        agreeButton.click();
    }

    public void selectYesSubscribeRadioButton() {
        yesSubscribeRadioButton.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public String existingEmailWarning() {
        return existingEmailWarning.getText();
    }

    public boolean displayIncorrectConfirmPasswordWarning() {
        return incorrectConfirmPasswordWarning.isDisplayed();
    }

    public String privacyPolicyWarning() {
        return privacyPolicyWarning.getText();
    }

    public boolean displayFirstNameWarning() {
        return firstNameWarning.isDisplayed();
    }

    public boolean displayLastNameWarning() {
        return lastNameWarning.isDisplayed();
    }

    public boolean displayEmailWarning() {
        return emailWarning.isDisplayed();
    }

    public boolean displayPhoneWarning() {
        return phoneWarning.isDisplayed();
    }

    public boolean displayPasswordWarning() {
        return passwordWarning.isDisplayed();
    }

    public SuccessfullyRegisterPage directlyToSuccessfullyRegisterPage(String firstname, String lastname,
                                                                       String emailText, String phoneNumber, String passwordText, String confirmPasswordText) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        email.sendKeys(emailText);
        phone.sendKeys(phoneNumber);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(confirmPasswordText);
        agreeButton.click();
        continueButton.click();

        return new SuccessfullyRegisterPage(driver);
    }

    public SuccessfullyRegisterPage directlyToSuccessfullyRegisterPageAllFields(String firstname, String lastname,
                                                                       String emailText, String phoneNumber, String passwordText, String confirmPasswordText) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        email.sendKeys(emailText);
        phone.sendKeys(phoneNumber);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(confirmPasswordText);
        yesSubscribeRadioButton.click();
        agreeButton.click();
        continueButton.click();

        return new SuccessfullyRegisterPage(driver);
    }
}
