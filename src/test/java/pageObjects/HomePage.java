package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//span[text()='My Account']") WebElement BtnMyAccount;
    @FindBy(linkText = "Register") WebElement BtnRegister;
    @FindBy(linkText = "Login") WebElement BtnLogin;


    //Actions
    public void clickMyAccount(){
        BtnMyAccount.click();
    }

    public void clickRegister(){
        BtnRegister.click();
    }

    public void clickLogin(){
        BtnLogin.click();
    }



}
