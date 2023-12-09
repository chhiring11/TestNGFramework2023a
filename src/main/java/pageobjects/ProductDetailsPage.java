package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericMethods;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@aria-label='M']")
    WebElement sizeOfTshirt;

    @FindBy(xpath = "//div[@aria-label='Purple']")
    WebElement colorOfTshirt;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@data-bind=\"css: { empty: !!getCartParam('summary_count') == false && !isLoading() }, blockLoader: isLoading\"]")
    WebElement productAddedSuccessfully;

    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//button[@title='Proceed to Checkout']")
    WebElement proceedToCheckOutButton;

    public void clickOnProceedToCheckOutButton(){

        proceedToCheckOutButton.click();
    }

    public void clickOnShoppingCartButton(){

        shoppingCartButton.click();
    }

    public boolean verifyIfAddToCartButtonIsDisplayed(){
        return addToCartButton.isDisplayed();
    }

    /*public boolean verifyAddToCartButtonIsDisplayed() {
       Actions action = new Actions(driver);
       return addToCartButton.isDisplayed();
    }*/

    public void selectSizeOfProduct() {
        sizeOfTshirt.click();
    }

    public boolean verifyIfSizeIsSelected() {
        return sizeOfTshirt.isDisplayed();
    }

    public void selectColorOfProduct(){
        colorOfTshirt.click();
    }

    public boolean verifyIfColorIsSelected() {
        return colorOfTshirt.isDisplayed();
    }

    public void clickOnAddToCart(){
        addToCartButton.click();
        GenericMethods.pauseExecutionFor(2);
    }
public boolean verifyIfUserIsAbleToAddProductToCart(){
        return addToCartButton.isDisplayed();
}
public void clickOnShoppingCartQuantityButton(){
        productAddedSuccessfully.click();
}
public boolean verifyIfproductAddedSuccessfully(){
        return productAddedSuccessfully.isDisplayed();
}

}
