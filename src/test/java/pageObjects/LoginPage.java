package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath="//input[@name='email']") WebElement txtEmail;
    @FindBy(xpath="//input[@name='password']") WebElement txtPassword;
    @FindBy(xpath = "//input[@type='submit']") WebElement btnSubmit;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement error;

    //Actions
    public void enterEmail(String Email){
        txtEmail.sendKeys(Email);
    }
    public void enterPassword(String Password){
        txtPassword.sendKeys(Password);
    }
    public void clickSubmit(){
        btnSubmit.click();
    }

}
