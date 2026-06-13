package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    //PgaeFactory
    @FindBy(linkText="Logout")
    public WebElement btnLogOut;
    //Actions
    public void clickLogOut(){
        btnLogOut.click();
    }


}
