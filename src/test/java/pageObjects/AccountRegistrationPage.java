package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

    //Constructor
    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//div[@id='content']/h1") WebElement txtRegPage;
    @FindBy(xpath = "//input[@name='firstname']") WebElement txtRegFirstName;
    @FindBy(xpath = "//input[@name='lastname']") WebElement txtRegLastName;
    @FindBy(xpath = "//input[@name='email']") WebElement txtRegEmail;
    @FindBy(xpath = "//input[@name='telephone']") WebElement txtRegTelephone;
    @FindBy(xpath = "//input[@name='password']") WebElement txtRegPassword;
    @FindBy(xpath = "//input[@name='confirm']") WebElement txtRegConfirmPassword;
    @FindBy(xpath = "(//label[@class='radio-inline'])[2]") WebElement chkRegNewsLetter;
    @FindBy(xpath = "//input[@type='checkbox']") WebElement chkRegRead;
    @FindBy(xpath = "//input[@type='submit']") WebElement BtnRegSubmit;
    @FindBy(xpath = "//div[@id='content']/h1") WebElement txtRegSuccess;
    @FindBy(xpath = "//div[@class='pull-right']/a") WebElement BtnContinue;


    //Actions
    public void setTxtRegFirstName(String FirstName){
        txtRegFirstName.sendKeys(FirstName);
    }
    public void setTxtRegLastName(String LastName){
        txtRegLastName.sendKeys(LastName);
    }
    public void setTxtRegEmail(String Email){
        txtRegEmail.sendKeys(Email);
    }
    public void setTxtRegTelephone(String Telephone){
        txtRegTelephone.sendKeys(Telephone);
    }
    public void setTxtRegPassword(String Password){
        txtRegPassword.sendKeys(Password);
    }
    public void setTxtRegConfirmPassword(String Password){
        txtRegConfirmPassword.sendKeys(Password);
    }
    public void setChkRegNewsLetter(){
        chkRegNewsLetter.click();
    }
    public void setChkRegRead(){
        chkRegRead.click();
    }
    public void setBtnRegSubmit(){
        BtnRegSubmit.click();
    }
    public String getSuccessTxt(){
        return txtRegSuccess.getText();
    }
    public void clickContinue(){
        BtnContinue.click();
    }
}
