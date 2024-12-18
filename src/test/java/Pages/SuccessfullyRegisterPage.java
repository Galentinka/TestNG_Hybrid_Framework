package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfullyRegisterPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@id='content']/p[1]")
    private WebElement successMessage;

    public SuccessfullyRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean successfullyRegistered() {
        return successMessage.isDisplayed();
    }
}
