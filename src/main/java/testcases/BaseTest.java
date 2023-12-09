package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.HomePage;
import pageobjects.ProductDetailsPage;
import pageobjects.ShippingAddressPage;
import utils.BrowserFactory;
import utils.GenericMethods;

public class BaseTest {

    WebDriver driver = null;
    HomePage homePage;

    ProductDetailsPage productDetailsPage;

    AddToCartPage addToCartPage;

    ShippingAddressPage shippingAddressPage;



    @BeforeClass
    public void setUp(){
        driver = BrowserFactory.launchGivenBrowser("Chrome");
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);

    }

    @Test (priority = 1)
    public void verifyIfWebsiteLaunchSuccessfully(){
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/women.html']")).isDisplayed());

    }

    @Test (priority = 2)
    public void verifyIfProductsAreListed(){
        Assert.assertTrue(homePage.verifyIfProductsAreListed());
    }

    @Test (priority = 3)
    public void verifyIfAddToCartButtonIsDisplayed(){

        Assert.assertTrue(homePage.verifyAddToCartButtonIsDisplayed());
        GenericMethods.pauseExecutionFor(1);
    }

    @Test (priority = 4)
    public void verifyClickingOnProductRedirectingProductDetailsPage(){
       homePage.clickOnProduct();
        Assert.assertTrue(productDetailsPage.verifyIfAddToCartButtonIsDisplayed());
    }

    @Test (priority = 5)
    public void verifyUserIsAbleToSelectSize(){
        productDetailsPage.selectSizeOfProduct();
        GenericMethods.pauseExecutionFor(1);
        Assert.assertTrue(productDetailsPage.verifyIfSizeIsSelected());
    }

    @Test (priority = 6)
    public void verifyUserIsAbleToSelectColor(){
        productDetailsPage.selectColorOfProduct();
        GenericMethods.pauseExecutionFor(1);
        Assert.assertTrue(productDetailsPage.verifyIfColorIsSelected());
    }

    @Test (priority = 7)
    public void verifyIfUserIsAbleToAddToCart(){
        productDetailsPage.verifyIfUserIsAbleToAddProductToCart();
        GenericMethods.pauseExecutionFor(2);
        Assert.assertTrue(productDetailsPage.verifyIfUserIsAbleToAddProductToCart());
    }

    @Test(priority = 8)
    public void verifyIfProductIsAddedIntoCartSuccessfully(){
        productDetailsPage.verifyIfproductAddedSuccessfully();
        GenericMethods.pauseExecutionFor(2);
        productDetailsPage.clickOnAddToCart();
        GenericMethods.pauseExecutionFor(2);
        Assert.assertTrue(productDetailsPage.verifyIfproductAddedSuccessfully());
    }

@Test (priority = 9)
public void verifyIfProceedToCheckOutButtonIsDisplayed(){
        productDetailsPage.clickOnShoppingCartButton();
        GenericMethods.pauseExecutionFor(2);
}

@Test (priority = 10)
public void verifyIfProceedToCheckOutButtonIsClicked(){
        productDetailsPage.clickOnProceedToCheckOutButton();
        GenericMethods.pauseExecutionFor(2);
}

/*@Test (priority = 11)
public void enterAllShippingDetails(){
    shippingAddressPage.enterEmailAddressField();
    GenericMethods.pauseExecutionFor(2);

}
*/


    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
