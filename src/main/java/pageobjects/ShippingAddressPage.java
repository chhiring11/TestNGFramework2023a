package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
    WebDriver driver;

    public ShippingAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@data-bind,'textInput: email,')]")
    WebElement emailAddressField;

   /* @FindBy(xpath = "//body/div[contains(@class,'page-wrapper')]/main[contains(@class,'page-main')]/div[contains(@class,'columns')]/div[contains(@class,'column main')]/div[contains(@class,'checkout-container')]/div[contains(@class,'opc-wrapper')]/ol[contains(@class,'opc')]/li[contains(@class,'checkout-shipping-address')]/div[contains(@class,'step-content')]/form[contains(@class,'form form-shipping-address')]/div[contains(@class,'fieldset address')]/div[1]/div[1]/input[1]")
    WebElement firstNameField;

    @FindBy(xpath = "//body/div[contains(@class,'page-wrapper')]/main[contains(@class,'page-main')]/div[contains(@class,'columns')]/div[contains(@class,'column main')]/div[contains(@class,'checkout-container')]/div[contains(@class,'opc-wrapper')]/ol[contains(@class,'opc')]/li[contains(@class,'checkout-shipping-address')]/div[contains(@class,'step-content')]/form[contains(@class,'form form-shipping-address')]/div[contains(@class,'fieldset address')]/div[2]/div[1]/input[1]")
    WebElement lastNameField;*/

    public void enterEmailAddressField(){
        emailAddressField.sendKeys("chhiring1998@gmai.com");
    }



}




