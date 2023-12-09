package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericMethods;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@alt='Breathe-Easy Tank']")
    WebElement hotSellersProduct;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[2]")
    WebElement addToCartButton;

    public boolean verifyIfProductsAreListed(){
        return hotSellersProduct.isDisplayed();
    }

    public void clickOnProduct(){
        hotSellersProduct.click();
    }

   public boolean verifyAddToCartButtonIsDisplayed(){
        Actions action = new Actions(driver);
        action.moveToElement(hotSellersProduct).build().perform();
        GenericMethods.pauseExecutionFor(2);
        return addToCartButton.isDisplayed();
    }
}
