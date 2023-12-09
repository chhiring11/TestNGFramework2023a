package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement showCartButton;

    @FindBy(xpath = "//button[@title='Proceed to Checkout']")
    WebElement proceedToCheckout;

    public void clickOnShowCartButton() {
        showCartButton.click();
    }

    public void clickOnProceedToCheckout() {
        proceedToCheckout.click();
    }

    public boolean verifyIfShowCartButtonIsDisplayed() {
        Actions action = new Actions(driver);
        action.moveToElement(proceedToCheckout).build().perform();
        return proceedToCheckout.isDisplayed();
    }

}

